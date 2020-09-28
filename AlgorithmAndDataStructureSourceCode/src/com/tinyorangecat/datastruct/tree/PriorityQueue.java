package com.tinyorangecat.datastruct.tree;

import java.util.Arrays;

public class PriorityQueue {
    //构建最小优先队列
    private int []queueArray;
    private int size;

    public PriorityQueue(int capacity){
        this.queueArray = new int[capacity];
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/28 11:23
     * @Description Put a data into priority queue.
     * @Param data
     * @Return void
     **/
    public void enQueue(int data){
        if(size >= queueArray.length){
            expansion();
        }
        queueArray[size++]=data;
        floatUpward();
    }

    private void expansion(){
        int newSize = this.size*2;
        this.queueArray = Arrays.copyOf(this.queueArray,newSize);
    }

    private void floatUpward(){
        int childIndex = size - 1;
        int parentIndex = (childIndex-1)/2;
        int temp = queueArray[childIndex];
        while (childIndex > 0 && temp < queueArray[parentIndex]){
            queueArray[childIndex] = queueArray[parentIndex];
            childIndex = parentIndex;
            parentIndex = childIndex/2;//这里除2即可
        }
        queueArray[childIndex] = temp;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/28 11:24
     * @Description A data out of the queue.
     * @Return int
     **/
    public int deQueue()throws Exception{
        if(size <= 0){
            throw new IndexOutOfBoundsException("队列为空！！");
        }
        int head = queueArray[0];
        queueArray[0] = queueArray[--size];//--size,先减再赋值
        goDown();
        return head;
    }

    private void goDown(){
        int parentIndex = 0;//整个队列需要下沉
        int childIndex = 1;//层序遍历
        int temp = queueArray[parentIndex];
        while (childIndex < size){
            if(childIndex+1 < size && queueArray[childIndex+1] < queueArray[childIndex]){
                childIndex++;
            }
            if(temp <= queueArray[childIndex]){
                break;
            }
            queueArray[parentIndex] = queueArray[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 + 1;
        }
        queueArray[parentIndex] = temp;
    }

    public void output(){
        System.out.println("Priority queue size: "+size);
        System.out.print("Priority queue is:[");
        for (int i = 0;i < size;i++){
            System.out.print(queueArray[i]);
            if(i < size-1){
                System.out.print(", ");
            }
        }
        System.out.println("].");
        System.out.println(Arrays.toString(queueArray));
    }
}
