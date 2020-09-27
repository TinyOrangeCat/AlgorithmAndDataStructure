package com.tinyorangecat.datastruct.tree.test;

import com.tinyorangecat.datastruct.tree.BinaryHeap;
import org.junit.Test;

import java.util.Arrays;

public class BinaryHeapOperationTest {

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
    public void floatForwardTest(){
        int []array = {1,3,2,6,5,7,8,9,10,0};
        BinaryHeap.floatUpward(array);
        System.out.println(Arrays.toString(array));
    }
}
