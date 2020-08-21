package practice;

/**
 * 前缀树
 */
//public class Pratice4 {
//
//
//
//}

class TrieTree{

    class Node{
        public int cross;

        public int end;

        public Node[] paths;

        Node(){
            cross = 0;
            end = 0;
            paths = new Node[26];
        }

    }
    Node root;

    TrieTree(){
        root = new Node();
    }

    public void insert(String str){

        char[] charArr = str.toCharArray();
        int len = charArr.length;
        Node tmpNode = root;
        for(int i=0;i < len; i++){
            int index = charArr[i] - 'a';
            if(tmpNode.paths[index] == null){
                tmpNode.paths[index] = new Node();
            }
            tmpNode = tmpNode.paths[index];
            tmpNode.paths[index].cross++;
        }
            tmpNode.end++;

    }

    public int seach(String str){
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        Node tmpNode = root;

        for(int i=0;i < len; i++){
            int index = charArr[i] - 'a';
            if(tmpNode.paths[index] == null){
                return 0;
            }
            tmpNode = tmpNode.paths[index];
        }
        return tmpNode.end;
    }

    public void del(String str){
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        Node tmpNode = root;

        for(int i=0;i < len; i++){
            int index = charArr[i] - 'a';
            tmpNode.paths[index].cross--;

            if(tmpNode.paths[index].cross == 0){
                tmpNode.paths[index].paths = null;
                return;
            }
            tmpNode = tmpNode.paths[index];
        }
        tmpNode.end--;
    }

    /**
     * 以 str 为前缀的有多少个
     * @param str
     */
    public int preNum(String str){
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        Node tmpNode = root;

        for(int i=0;i < len; i++){
            int index = charArr[i] - 'a';
            if(tmpNode.paths[index] == null){
                return 0;
            }
            tmpNode = tmpNode.paths[index];
        }
        return tmpNode.cross;
    }

}
