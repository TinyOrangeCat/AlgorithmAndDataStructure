package com.tinyorangecat.datastruct.tree.test;

public class TheBinaryHeap {

    public static void createBinaryHeap(int []array){
        for(int i = (array.length-2)/2;i >= 0;i--){
            goDown(array,i,array.length);
        }
    }

    public static void goDown(int []array,int index,int border){
        int parentIndex = index;
        int childIndex = parentIndex*2+1;
        int tempt = array[parentIndex];
        while(childIndex < border){
            if(childIndex + 1 < border && array[childIndex + 1] < array[childIndex]){
                childIndex++;
            }
            if(tempt <= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = tempt;
    }

    public static void floatForward(int []array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1)/2;
        int tempt = array[childIndex];
        while (childIndex > 0 && tempt < array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
        array[childIndex] = tempt;
    }
}
