package com.algorithm.cow001;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集
 *
 * 是一种树形结构
 */
public class Sty002 {


}

class UnionFindSet{

    class Node{
        int data;
    }

    /**
     * key:当前节点  value:当前节点的父节点
     */
    Map<Node,Node> fathMap;
    /**
     * key:节点  value:当前节点下的 子节点个数
     */
    Map<Node,Integer> nodesNumMap;

    UnionFindSet(List<Node> nodes){//初始化一个并查集
        fathMap = new HashMap<>();
        nodesNumMap = new HashMap<>();

        for(Node node : nodes){
            fathMap.put(node, node);
            nodesNumMap.put(node,1);
        }
    }

    public void unior(Node a,Node b){
        if(null == a || null == b){
            return;
        }

        Node rootA = findRoot(a);
        Node rootB = findRoot(b);

        if(rootA != rootB){
            int numA = nodesNumMap.get(a);
            int numB = nodesNumMap.get(b);
            if(numA >= numB){
                fathMap.put(b,a);
                nodesNumMap.put(a,numA+numB);
            }else{
                fathMap.put(a,b);
                nodesNumMap.put(b, numA + numB);
            }
        }


    }

    public Node findRoot(Node node){

        if(node == null){
            return null;
        }
     //   Node father = fathMap.get(node);
        Node temNode = node;
        while(fathMap.get(node) != node){
            node = fathMap.get(node);
        }
        //每次查询完之后，把node挂到 顶级父节点上
        fathMap.put(temNode,node);
        return node;
    }

    public boolean find(Node a,Node b){
        if(null == a || null == b){
            return false;
        }
        Node rootA = findRoot(a);
        Node rootB = findRoot(b);
        if(rootA == rootB){
            return true;
        }else{
            return  false;
        }
    }
}
