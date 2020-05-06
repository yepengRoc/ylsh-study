package com.algorithm.cow;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * 用队列实现栈结构
 *
 * 队列是先进先出
 * 栈是先进后出。就是后进先出
 *
 * 这里的前提是，队列只能从 头出数据
 *  需要一个辅助队列，和一个取数队列
 *  每次从取数的时候，把取数队列的 前 1-n个数放入到辅助队列，然后取取数队列的剩下的一个数
 *  然后交互两个队列的角色 辅助队列=取数队列  取数队列=辅助队列
 *
 *
 *
 */
public class Sty026 {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        //arrayQueue.
    }
}
