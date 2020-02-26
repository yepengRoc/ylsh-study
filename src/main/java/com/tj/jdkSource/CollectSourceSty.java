package com.tj.jdkSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.LongAdder;

public class CollectSourceSty {
    /**
     * ArrayList学习
     */
    public void arrayListSty(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.indexOf(1);
        list.set(0, 2);
    }

    /**
     * LinkedList学习
     */
    public void linkedListSty(){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.indexOf(1);
        list.set(0, 2);
    }

    /**
     * CopyOnWriteArrayList 学习
     */
    public void copyOnWriterArrayListSty(){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        //在指定索引位置添加元素
        list.add(1,1);
        list.addIfAbsent(1);//如果没有的话则添加
        list.indexOf(1);
        list.set(0, 2);
        list.remove(1);
        list.remove(Integer.valueOf(1));
        list.contains(1);
    }

    /**
     * HashMap学习
     */
    public void HasMapSty(){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("a", "b");
        hashMap.remove("a");


    }

    /**
     * LinkedHashMap学习
     */
    public void linkedHashMapSty(){
        LinkedHashMap<String, Object> lhp = new LinkedHashMap<>();
        lhp.put("a", "b");
        lhp.remove("a");

    }
    /**
     * WeakHashMap学习
     */
    public void weakHashMapSty(){
        WeakHashMap weakHashMap = new WeakHashMap();
        weakHashMap.put("a", "b");
    }
    public void concurrentHashMapSty(){
        ConcurrentHashMap<String, Integer> concurHashMap = new ConcurrentHashMap<>();
    }



    /**
     * TreeMap学习
     */
    public void treeMapSty(){

    }
    public void hashSetSty(){
        
    }
    public void linkedHashSetSty(){
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

    }
    public void treeSetSty(){
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        
    }
    public void copyOnWriteArraySetSty(){
        
    }
    public void concurrentSkipListSetSty(){
        
    }
   /* public void priorityQueueSty(){

    }*/
    public void PriorityQueueSty(){
        //优先队列，一般会指定业务排序规则
        PriorityQueue que = new PriorityQueue(10, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        que.add(1);
        que.remove();
        que.remove(1);
    }
    public void ArrayBlockingQueueSty(){
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<Integer>(10);
        arrayBlockingQueue.add(1);
        //add    put是阻塞式的
        arrayBlockingQueue.offer(1);
    }
    public void LinkedBlockingQueueSty(){
        //无界队列
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();


    }
    public void SynchronousQueueSty() throws Exception{
        /**
         * 非公平模式是 stck 栈 公平模式是 queue
         */
        SynchronousQueue<Integer> que = new SynchronousQueue<>();
        que.add(1);
        que.take();
        que.peek();
        que.poll();


    }
    public void PriorityBlockingQueueSty(){

    }
    public void LinkedTransferQueueSty(){

    }
    public void ConcurrentLinkedQueueSty(){

    }
    public void DelayQueueSty(){

    }
    public void ArrayDequeSty(){

    }
    


//— ConcurrentSkipListSet
// PriorityQueue

// ArrayBlockingQueue

// LinkedBlockingQueue

// SynchronousQueue

// PriorityBlockingQueue

// LinkedTransferQueue

// ConcurrentLinkedQueue

// DelayQueue
// ArrayDeque
//
// LinkedList

    public void longAddrSty(){
        LongAdder longAdder = new LongAdder();
        longAdder.add(1);
        longAdder.sum();
    }


}
