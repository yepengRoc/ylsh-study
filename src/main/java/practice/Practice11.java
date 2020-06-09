package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 贪心策略
 */
public class Practice11 {


    /**
     * 分铜板问题
     * 通过小顶堆来实现。实现代价最小计算
     */
    public void fenTongBan(){

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        List<Integer> list = new ArrayList<>();

        for(Integer integer : list){
            priorityQueue.add(integer);
        }

        while(priorityQueue.size() > 1){
            int pay = priorityQueue.poll() + priorityQueue.poll();
            priorityQueue.add(pay);
        }

        System.out.println("最小代价：" + priorityQueue.poll());

    }

    /**
     * 收益问题
     */

    /**
     * 会议室问题
     */

}
