package com.tinyorangecat.algorithm.sort.test;

import com.tinyorangecat.algorithm.sort.HeapSort;
import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {

    @Test
    public void heapTest(){
        int []array = {4, 4, 6, 5,50, 3, 2, 8, 1,2};
        System.out.println(Arrays.toString(array));
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
