package com.ylsh.study.books.cxydmmszn;

import org.junit.Test;

import java.util.Stack;

public class Sty001 {

    /**
     *没有空间限制。通过getMin() 获取栈中的最小元素
     * 实现一个特殊的栈，在原来基本功能上，再实现返回栈中的最小值 。以空间换时间
     * 时间复杂度 o(1)
     */
    @Test
    public void test1(){
        MyStack myStack = new MyStack();
        myStack.push(5);
        myStack.push(9);
        myStack.push(4);
        myStack.push(3);
        myStack.push(7);

        System.out.println("当前最小值"+ myStack.getMin());

        System.out.println("pop"+myStack.pop()+"当前最小值"+ myStack.getMin());
        System.out.println("pop"+myStack.pop()+"当前最小值"+ myStack.getMin());
        System.out.println("pop"+myStack.pop()+"当前最小值"+ myStack.getMin());
        System.out.println("pop"+myStack.pop()+"当前最小值"+ myStack.getMin());
        System.out.println("pop"+myStack.pop()+"当前最小值"+ myStack.getMin());

    }
    class MyStack{
        Stack<Integer> stackData = new Stack();//用来存储数据
        Stack<Integer> stackMin = new Stack();//用来存储小数据

        public void push(Integer num){
            if(null == num){
                return;
            }
            stackData.push(num);
            if(stackMin.empty()){
                stackMin.push(num);
                return;
            }
            Integer topData = stackMin.peek();
            if(topData.intValue() >= num.intValue()){
                stackMin.push(num);
                return;
            }
            /**
             * 还有一种实现方式。如果数据不小于 小栈顶部的数据，则去小栈顶部的数据，再压一次栈
             * 这样的好处是，stackData在pop弹出的时候，stackMin也直接弹出就行了，不应判断，
             * 但是这样比较耗内存空间
             * Integer topData = stackMin.peek();
             *             if(topData.intValue() >= num.intValue()){
             *                 stackMin.push(num);
             *                 return;
             *             }else{
             *                 stackMin.push(topData);
             *             }
             */

        }
        public Integer pop(){
            if(stackData.empty()){
                return 0;
            }
            Integer topData = stackData.pop();
            Integer minTopData = stackMin.peek();
            if(topData.intValue() == minTopData.intValue()){//这样可以保证stackMin中的顶部元素，永远是stackData中剩余元素的最小元素
                stackMin.pop();
            }
            /**
             * 如果是上面第二种实现方式，则直接弹出就可以了，不用判断
             */
            return topData;
        }

        public Integer getMin(){
            if(!stackMin.empty()){
                return stackMin.peek();
            }
            return 0;
        }
    }

}
