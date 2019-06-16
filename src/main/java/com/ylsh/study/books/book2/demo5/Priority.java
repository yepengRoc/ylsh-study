package com.ylsh.study.books.book2.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Priority {

    private static volatile boolean notStart = true;

    private static volatile boolean notEnd = true;

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<Job>();
        for(int i = 0;i < 10;i++){
            int priority = i < 5? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job,"Thread:" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notEnd = false;
        for(Job job : jobs){
            System.out.println("T");

        }
    }

    static class  Job implements Runnable{

        private int priority;
        private int jobCount;

        public Job(int priority){
            this.priority = priority;
        }
        
        public void run() {
            while (notStart){
                Thread.yield();
            }
            while (notEnd){
                jobCount++;
            }
        }
    }
}
