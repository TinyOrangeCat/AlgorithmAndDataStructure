package com.tinyorangecat.algorithm.interview;

import java.util.Stack;

public class QueueByStack {

    private Stack<Integer> enQueue = new Stack<Integer>();
    private Stack<Integer> deQueue = new Stack<Integer>();

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/4 13:19
     * @Description Put a data into a queue that is created by stack.
     * @Param data
     * @Return
     **/
    public void enQueue(int data){
        enQueue.push(data);

    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/4 13:21
     * @Description De-queue that is created by stack.
     * @Param
     * @Return Integer
     **/
    public Integer deQueue(){
        if(enQueue.isEmpty() && deQueue.isEmpty()){
            return null;
        }
        if(deQueue.isEmpty()){
            while (!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
        }
        return deQueue.pop();
    }
}
