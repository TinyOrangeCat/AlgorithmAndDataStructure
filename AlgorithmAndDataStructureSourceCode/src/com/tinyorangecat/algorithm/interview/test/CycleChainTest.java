package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.CycleChain;
import org.junit.Test;

public class CycleChainTest {

    @Test
    public void isCycleChainTest(){
        CycleChain.Node chain = new CycleChain.Node(5);
        CycleChain.Node node1 = new CycleChain.Node(3);
        CycleChain.Node node2 = new CycleChain.Node(7);
        CycleChain.Node node3 = new CycleChain.Node(2);
        CycleChain.Node node4 = new CycleChain.Node(6);
        CycleChain.Node node5 = new CycleChain.Node(8);
        CycleChain.Node node6 = new CycleChain.Node(1);
        chain.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        System.out.println(chain);
        System.out.println("is cycle chain:"+CycleChain.hasCycleChain(chain));
    }

    @Test
    public void reviewTest(){
        ReviewCycleChain.ChainNode chain = new ReviewCycleChain.ChainNode(5);
        ReviewCycleChain.ChainNode node1 = new ReviewCycleChain.ChainNode(3);
        ReviewCycleChain.ChainNode node2 = new ReviewCycleChain.ChainNode(7);
        ReviewCycleChain.ChainNode node3 = new ReviewCycleChain.ChainNode(2);
        ReviewCycleChain.ChainNode node4 = new ReviewCycleChain.ChainNode(6);
        ReviewCycleChain.ChainNode node5 = new ReviewCycleChain.ChainNode(8);
        ReviewCycleChain.ChainNode node6 = new ReviewCycleChain.ChainNode(1);
        chain.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        System.out.println(chain);
        System.out.println("is cycle chain:"+ReviewCycleChain.isCycleChain(chain));
    }
}
