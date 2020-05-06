package com.algorithm.cow;

import java.util.Stack;

/**
 * 实现一个特殊的栈，    取栈中最小元素
 *
 * 增加一个辅助栈，
 * 第一个元素压栈
 * 栈1  栈2    这里栈2是辅助栈
 * 栈1压  栈2也压入
 */
public class Sty025 {



    void method(){



    }
}

class SpecialStack{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    void addEleMent(int val){

       if(stack2.size() == 0){
           stack2.add(val);
       }else{
           int topVal = stack2.peek();
           if(val < topVal){
               stack2.add(val);
           }else{
               stack2.add(topVal);//再压一次
           }
       }

    }

    //取最小值得时候，直接从stack2 pop即可
}
