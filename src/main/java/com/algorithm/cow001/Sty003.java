package com.algorithm.cow001;

import java.util.PriorityQueue;

/**
 * 贪心策略
 *
 * 给定一个字符串，找到一种拼接方式，使得手游字符串凭借起来之后形成的字符串具有最低的字典序
 */
public class Sty003 {


    /**
     * 金条和铜板的问题
     * @param arr
     * @return
     */
    public  int leeMoney(int[] arr){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


        for(int i: arr){
            priorityQueue.add(i);
        }
        int rst = 0;
        int curPos = 0;
        while(priorityQueue.size() > 1){
            curPos = priorityQueue.poll() + priorityQueue.poll();
            rst = rst + curPos;
            priorityQueue.add(curPos);
        }
            return 0;
    }

    /**
     * 会议室问题
     * 需要敲一敲
     */

}

