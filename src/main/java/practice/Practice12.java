package practice;

public class Practice12 {


    /**
     * 打印一个字符串的所有子序列
     */

    public void printStr1(char[] charArr,int index,String str){

        if(index == charArr.length - 1){
            System.out.println(str);
            return;
        }
        printStr1(charArr,index+1,str+charArr[index]);//要下一个字符
        printStr1(charArr,index+1,str);//不要下一个字符

    }

    /**
     * 打印一个字符串的全排列
     * @param charArr
     * @param index
     * @param
     */
    public void print2(char[] charArr,int index){

        if(index == charArr.length -1){
            System.out.println(charArr.toString());
            return;
        }

        for(int i= index;i < charArr.length;i++){
           // swap(charArr,index,i);
            print2(charArr,index+1);
        }

    }
    /**
     * 母牛生小牛的问题
     *
     * f(n) = f(n-1) + f(n-3)
     */



}
