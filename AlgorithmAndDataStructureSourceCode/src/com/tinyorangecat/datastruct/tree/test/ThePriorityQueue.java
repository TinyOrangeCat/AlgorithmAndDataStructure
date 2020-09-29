package com.tinyorangecat.datastruct.tree.test;

import java.util.Arrays;

public class ThePriorityQueue {
    private int []queueArray;
    private int size;

    public ThePriorityQueue(int capacity){
        this.queueArray = new int[capacity];
        this.size = 0;
    }

    public void enQueue(int data){
        if(size >= queueArray.length){
            expansion();
        }
        queueArray[size++] = data;
        floatForward();
    }

    private void expansion(){
        int newLength = this.size*2;
        Arrays.copyOf(queueArray,newLength);
    }

    private void floatForward(){
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1)/2;
        int temp = queueArray[childIndex];
        while (childIndex > 0 && temp < queueArray[parentIndex]){
            queueArray[childIndex] = queueArray[parentIndex];
            childIndex = parentIndex;
            parentIndex = childIndex/2;
        }
        queueArray[childIndex] = temp;
    }

    public int deQueue()throws Exception{
        if(size == 0){
            throw new IndexOutOfBoundsException("优先队列为空！！");
        }
        int deleteData = queueArray[0];
        queueArray[0] = queueArray[--size];
        goDown();
        return deleteData;
    }

    private void goDown(){
        int parentIndex = 0;
        int childIndex = 1;
        int temp = queueArray[parentIndex];
        while(childIndex < size){
            if(childIndex + 1 < size && queueArray[childIndex+1] < queueArray[childIndex]){
                childIndex++;
            }
            if(temp <= queueArray[childIndex]){
                break;
            }
            queueArray[parentIndex] = queueArray[childIndex];
            parentIndex = childIndex;
            childIndex = (parentIndex + 1)*2;
        }
        queueArray[parentIndex] = temp;
    }

    public void output(){
        System.out.println("The queue size is : "+size);
        System.out.print("The queue is : [");
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
