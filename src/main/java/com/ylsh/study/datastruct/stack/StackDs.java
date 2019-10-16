package com.ylsh.study.datastruct.stack;

import java.lang.reflect.Array;

/**
 * 栈的特点是数据先进后出
 * 可以通过数组和链表进行实现
 * <p>
 * 数组栈，每次取数据都从尾部取
 * 链表栈同理。单向链表（最好有一个记录尾节点）和双向链表都可以实现
 * <p>
 * pop() 返回栈顶元素
 * peek() 返回并删除栈顶元素
 * push()压入栈中
 */
public class StackDs<T> {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 12;


    private T[] baseArr;

    private int arrLen = 0;

    private int size = 0;


    protected StackDs(Class<T> type){
        this(type,DEFAULT_CAPACITY);
    }
    protected StackDs(Class<T> type,int size){
        arrLen = size;
        //new T[size] 无法创建泛型数组
        baseArr = (T[])Array.newInstance(type,size);
    }

    public boolean push(T t){
        //放不下数据了
        if(size == arrLen){
            return false;
        }
        baseArr[size] = t;
        size++;
        return true;
    }

    public T pop(){
        if(size == 0){
            return null;
        }
        int idx = size -1;
        return baseArr[idx];
    }

    public T peek(){
        if(size == 0){
            return null;
        }
        //这里size已经减1
        T t = baseArr[--size];
        baseArr[size] = null;
        return t;
    }


}
