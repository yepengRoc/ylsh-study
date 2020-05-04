package com.algorithm.cow;

/**
 * 前缀树
 */
public class Sty015 {


}

class TrieTree{

    class TrieNode{

        public int across;//通过当前节点的次数

        public int end;//已当前节点为结束的 的字符串的个数

        public TrieNode[] paths;

        public TrieNode(){
            across = 0;
            end = 0;
            paths = new TrieNode[26];//因为前缀树是用来对字符操作的，所以是26个.还有大写字母。这里以小写字母进行举例。如果包含大写字母，则容量翻倍
        }

    }

    private TrieNode root;

    public TrieTree(){
        root = new TrieNode();
    }
    //向前缀树中插入一个节点
    public void insert(String str){
        if(null == str || str.length() < 1){
            return;
        }
        char[] chars = str.toCharArray();

        int len = chars.length;

        TrieNode curNode = root;//空节点
        for(int i=0;i< len;i++){
            int index = chars[i] - 'a';

            if(curNode.paths[index] == null){
                curNode.paths[index] = new TrieNode();
            }
            curNode = curNode.paths[index];
            curNode.across++;
        }
    }

    /**
     * 数据查询
     * @param str
     * @return
     */
    public int search(String str){
        if(null == str || str.length() < 1){
            return 0;
        }
        char[] chars = str.toCharArray();

        int len = chars.length;
        TrieNode curNode = root;//空节点
        for(int i=0;i< len;i++){
            int index = chars[i] - 'a';
            if(curNode.paths[index] == null){
                return 0;
            }
            curNode = curNode.paths[index];
        }
        if(curNode.end > 0){//说明有以这个字符结尾的字符串
            return  curNode.end;
        }
        return 0;
    }

    public void delete(String str){
        if(null == str || str.length() < 1){
            return;
        }
        int has = search(str);
        if(has < 1){
            return;
        }
        char[] chars = str.toCharArray();

        int len = chars.length;

        TrieNode curNode = root;//空节点
        for(int i=0;i< len;i++){
            int index = chars[i] - 'a';
            if(--curNode.paths[index].across == 0){//这一步判断很精妙
                curNode.paths[index] = null;
                return;
            }
            curNode = curNode.paths[index];
        }
        curNode.end--;
    }

    /**
     * 以 str为前缀的字符有多少
     * @param str
     * @return
     */
    public int prefixNum(String str){
        if(null == str || str.length() < 1){
            return 0;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        TrieNode curNode = root;//空节点
        for(int i=0;i< len;i++){
            int index = chars[i] - 'a';

            if(curNode.paths[index] == null){
                return 0;
            }
            curNode = curNode.paths[index];
        }
        return curNode.across;
    }
}
