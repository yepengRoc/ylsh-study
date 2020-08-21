package practice;

import org.apache.http.nio.protocol.HttpAsyncRequestHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集
 *
 * 处理不相交的合并及查询问题
 *
 *
 */
public class Practice10 {

    class Node{
        Node parent;

        int val;
    }

    private Map<Node, Node> fatherMap = new HashMap<>();

    private Map<Node,Integer> nodesNumMap = new HashMap<>();

    Practice10(List<Node> lists){

        for(Node node : lists){
            fatherMap.put(node,node);

            nodesNumMap.put(node,1);
        }
    }

    public Node getRoot(Node node){
        if(null == node){
            return null;
        }
        Node father = fatherMap.get(node);
        while (node != father){
            father = fatherMap.get(father);
        }
        fatherMap.put(node,father);
        return father;
    }

    public boolean find(Node a,Node b){
        if(null == a || null == b){return false;};

        Node aF = getRoot(a);
        Node bF = getRoot(b);

        return aF == bF ? true: false;
    }

    public void union(Node a,Node b){
        if(null == a || null == b){return;};

        Node rootA = getRoot(a);
        Node rootB = getRoot(b);

        if(rootA != rootB){
            int numA = nodesNumMap.get(a);
            int numB = nodesNumMap.get(b);

            if(numA >= numB){
                fatherMap.put(rootB,rootA);
                nodesNumMap.put(rootA,numA+numB);
            }else{
                fatherMap.put(rootA,rootB);
                nodesNumMap.put(rootB, numA + numB);
            }
        }
    }

}
