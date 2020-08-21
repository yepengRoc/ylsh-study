package practice;

/**
 * KMP
 */
public class Practice3 {


    /**
     * 获取辅助数组
     * 前缀和后缀的概念
     * 前缀 是不包含 尾部最后一个字符
     * 尾部是不包含 首字符的 字符串
     * @param charArr
     */
    public void getHelp(char[] charArr){

        if(null == charArr || charArr.length < 1){
            return;
        }
        int len = charArr.length;

        int[] helpArr = new int[len];

        helpArr[0] = -1;
        helpArr[1] = 0;

        int cn = 0;//因为 help[0] help[1] 位置没有匹配数据
        int index = 2;

        while(index < len){

            if(charArr[cn] == charArr[index]){
                helpArr[index] = helpArr[index -1]+1;
                cn++;
                index++;
            }else if(helpArr[cn] == -1){//到头了。说明没有匹配到
                helpArr[index] = 0;
                cn++;
                index++;

            }else{
                cn = helpArr[cn];
            }
        }
    }
    public int match(char[] src,char[] match){
        int srcLen = src.length;
        int matchLen = match.length;
        if(matchLen > srcLen){
            return -1;
        }
        int[] heplArr = null;
        int i = 0;
        int j = 0;
        while(i < srcLen && j < matchLen){
            if(src[i] == match[j]){
                i++;
                j++;
            }if(heplArr[j] != -1){//
                j = heplArr[j];//最小匹配索引执行 cn的位置
            }else{//开头位置。 help[j] = -1
                i++;
            }
        }
        //说明匹配到头了，也匹配到了
        return  j == srcLen ? i - matchLen : -1;
    }


    /**
     * 应用
     * 判断一个 二叉树 是否是另一个二叉树的子树
     * 中序遍历，然后比较
     *
     */

}
