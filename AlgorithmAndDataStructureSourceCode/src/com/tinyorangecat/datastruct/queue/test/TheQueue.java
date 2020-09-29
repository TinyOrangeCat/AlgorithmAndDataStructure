package com.tinyorangecat.datastruct.queue.test;

public class TheQueue {
    private int []array;
    private int rear;
    private int front;

    public TheQueue(int capacity){
        this.array = new int[capacity];
    }

    public void enQueue(int data)throws Exception{
        if((rear+1)%array.length == front){
            throw new IndexOutOfBoundsException("队列已满！");
        }
        array[rear] = data;
        rear = (rear+1)%array.length;
    }

    public int deQueue()throws Exception{
        if(rear == front){
            throw new IndexOutOfBoundsException("空队列！");
        }
        int deQueue = array[front];
        front = (front+1)%array.length;
        return deQueue;
    }

    public void output(){
        System.out.print("The Queue is :[");
        for(int i = front;i != rear;i = (i+1)%array.length){
            System.out.print(array[i]);
            if((i+1)%array.length != rear){
                System.out.print(", ");
            }
        }
        System.out.println("].");
    }
}
