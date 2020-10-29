package com.tinyorangecat.datastruct.queue;

public class MyQueue {
    private int []array;
    private int front;//头指针
    private int rear;//尾指针

    public MyQueue(int capacity){
        array = new int[capacity];
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/24 13:54
     * @Description A data enters into the cycle queue.
     * @Param element The data(should be the type of int) that will enters into the cycle queue.
     * @Return void
     **/
    public void enterQueue(int element)throws Exception{
        //a%b = a-(a/b)*b
        if((rear+1)%array.length == front){
            throw new IndexOutOfBoundsException("队列已满！！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/24 13:58
     * @Description Out of the queue.
     * @Return int The data which comes from the queue.
     **/
    public int outQueue()throws Exception{
        if(rear == front){
            throw new IndexOutOfBoundsException("空队列！！");
        }
        int deletedData = array[front];
        front = (front + 1) % array.length;
        return deletedData;
    }

    public void output(){
        System.out.println("Queue capacity = "+array.length+";");
        System.out.print("Queue:[");
        for(int i = front; i != rear; i=(i+1)%array.length){
            System.out.print(array[i]);
            if((i+1)%array.length != rear){
                System.out.print(", ");
            }
        }
        System.out.println("].");
    }
}
