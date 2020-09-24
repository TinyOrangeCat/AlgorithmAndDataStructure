package com.tinyorangecat.datastruct.queue.test;

import com.tinyorangecat.datastruct.queue.MyQueue;
import org.junit.Test;

public class QueueOperationTest {

    private MyQueue buildQueue()throws Exception{
        MyQueue myQueue = new MyQueue(6);
        myQueue.enterQueue(3);
        myQueue.enterQueue(5);
        myQueue.enterQueue(6);
        myQueue.enterQueue(8);
        myQueue.enterQueue(1);
        return myQueue;
    }

    @Test
    public void queueEnterTest()throws Exception{
        MyQueue queue = buildQueue();
        queue.output();
    }

    @Test
    public void queueOutTest()throws Exception{
        MyQueue queue = buildQueue();
        queue.output();
        System.out.println("Out of queue : "+queue.outQueue());
        System.out.println("Out of queue : "+queue.outQueue());
        queue.output();
        queue.enterQueue(7);
        queue.output();
    }
}
