package com.tinyorangecat.algorithm.interview.test;

public class ReviewCycleChain {
    public static class ChainNode{
        int data;
        ChainNode next;
        public ChainNode(int data){
            this.data = data;
        }
    }

    public static boolean isCycleChain(ChainNode chain){
        if(chain == null){
            return false;
        }
        ChainNode pointerOne = chain;
        ChainNode pointerTow = chain;
        while (pointerOne != null && pointerTow != null){
            pointerOne = pointerOne.next;
            pointerTow = pointerTow.next.next;
            if(pointerOne == pointerTow){
                return true;
            }
        }
        return false;
    }
}
