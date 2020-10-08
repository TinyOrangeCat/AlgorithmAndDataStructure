package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.QueueByStack;
import org.junit.Test;

public class QueueByStackTest {

    @Test
    public void queueByStackOperationTest()throws Exception{
        QueueByStack queue = new QueueByStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("De queue:"+queue.deQueue());
        System.out.println("De queue:"+queue.deQueue());
        queue.enQueue(4);
        System.out.println("De queue:"+queue.deQueue());
        System.out.println("De queue:"+queue.deQueue());
        System.out.println("De queue:"+queue.deQueue());
    }

    @Test
    public void reviewTest()throws Exception{
        ReviewStackCreateQueue queue = new ReviewStackCreateQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("De queue:"+queue.deQueue());
        System.out.println("De queue:"+queue.deQueue());
        queue.enQueue(4);
        System.out.println("De queue:"+queue.deQueue());
        System.out.println("De queue:"+queue.deQueue());
        System.out.println("De queue:"+queue.deQueue());
    }
}
