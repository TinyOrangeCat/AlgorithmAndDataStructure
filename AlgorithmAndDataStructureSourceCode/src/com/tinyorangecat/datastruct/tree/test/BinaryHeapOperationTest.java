package com.tinyorangecat.datastruct.tree.test;

import com.tinyorangecat.datastruct.tree.BinaryHeap;
import org.junit.Test;

import java.util.Arrays;

public class BinaryHeapOperationTest {

    private void goDown(int []array,int parentIndex,int length){
        int childIndex = parentIndex*2 + 1;
        int tempt = array[parentIndex];
        while (childIndex < length){
            if(childIndex+1 < length && array[childIndex+1] < array[childIndex]){
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

    private void floatUpward(int []array){
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
    private int[] buildBinaryHeap(){
        int []array = {7,1,3,10,5,2,8,9,6};
        BinaryHeap.buildBinaryHeap(array);
        return array;
    }
    @Test
    public void buildBinaryHeapTest(){
        int []array = {7,1,3,10,5,2,8,9,6};
        BinaryHeap.buildBinaryHeap(array);
        //int []binaryHeap = buildBinaryHeap();
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void buildBinaryHeapSelfTest(){
        int []array = {7,1,3,10,5,2,8,9,6};
        for(int i = (array.length-2)/2;i >= 0;i--){
            goDown(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void floatForwardTest(){
        int []array = {1,3,2,6,5,7,8,9,10,0};
        BinaryHeap.floatUpward(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void floatForwardSelfTest(){
        int []array = {1,3,2,6,5,7,8,9,10,0};
        floatUpward(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void reviewTest(){
        int []array = {7,1,3,10,5,2,8,9,6};
        TheBinaryHeap.createBinaryHeap(array);
        //int []binaryHeap = buildBinaryHeap();
        System.out.println(Arrays.toString(array));
        int []array2 = {1,3,2,6,5,7,8,9,10,0};
        TheBinaryHeap.floatForward(array2);
        System.out.println(Arrays.toString(array2));
    }
}
