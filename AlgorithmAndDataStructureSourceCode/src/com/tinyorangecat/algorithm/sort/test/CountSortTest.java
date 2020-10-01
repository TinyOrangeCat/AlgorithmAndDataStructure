package com.tinyorangecat.algorithm.sort.test;

import com.tinyorangecat.algorithm.sort.CountSort;
import org.junit.Test;

import java.util.Arrays;

public class CountSortTest {

    @Test
    public void countSortTest(){
        int []array = {10,11,5,6,8,1,7,2,6,2,5,4};
        System.out.println("countTest1 array:"+ Arrays.toString(array));
        CountSort.sort(array);
        System.out.println("countTest1 result:"+ Arrays.toString(array));
    }

    @Test
    public void improveCountSortTest(){
        int []array = {10,11,5,6,8,1,7,2,6,2,5,4};
        System.out.println("improveCountSortTest array:"+ Arrays.toString(array));
        ;
        System.out.println("improveCountSortTest result:"+ Arrays.toString(CountSort.improveSort(array)));
    }
}
