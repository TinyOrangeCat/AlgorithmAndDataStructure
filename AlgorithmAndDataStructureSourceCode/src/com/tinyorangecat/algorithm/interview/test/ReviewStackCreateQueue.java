package com.tinyorangecat.algorithm.interview.test;

import java.util.Stack;

public class ReviewStackCreateQueue {
    private Stack<Integer> enQueueStack = new Stack<Integer>();
    private Stack<Integer> deQueueStack = new Stack<Integer>();

    public void enQueue(int data){
        enQueueStack.push(data);
    }

    public Integer deQueue(){
        if(enQueueStack.isEmpty() && deQueueStack.isEmpty()){
            return null;
        }
        if(deQueueStack.isEmpty()){
            while (!enQueueStack.isEmpty()){
                deQueueStack.push(enQueueStack.pop());
            }
        }
        return deQueueStack.pop();
    }
}
