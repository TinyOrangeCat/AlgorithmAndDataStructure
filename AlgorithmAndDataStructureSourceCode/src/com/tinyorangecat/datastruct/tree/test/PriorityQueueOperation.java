package com.tinyorangecat.datastruct.tree.test;

import com.tinyorangecat.datastruct.tree.PriorityQueue;
import org.junit.Test;

public class PriorityQueueOperation {

    private PriorityQueue buildPriorityQueue(){
        PriorityQueue priorityQueue = new PriorityQueue(10);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        return priorityQueue;
    }
    @Test
    public void enPriorityQueueTest(){
        PriorityQueue priorityQueue = buildPriorityQueue();
        priorityQueue.output();
    }

    @Test
    public void dePriorityQueueTest()throws Exception{
        PriorityQueue priorityQueue = buildPriorityQueue();
        priorityQueue.output();
        System.out.println("Out the queue : "+priorityQueue.deQueue());
        priorityQueue.output();
    }

    @Test
    public void otherTest()throws Exception{
        ThePriorityQueue priorityQueue = new ThePriorityQueue(10);
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(6);
        priorityQueue.enQueue(4);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        priorityQueue.output();
        System.out.println("Out the queue : "+priorityQueue.deQueue());
        priorityQueue.output();
    }
}
