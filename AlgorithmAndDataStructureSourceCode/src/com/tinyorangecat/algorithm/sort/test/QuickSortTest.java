package com.tinyorangecat.algorithm.sort.test;

import com.tinyorangecat.algorithm.sort.QuickSort;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void doubleQuickSortTest(){
        int []array = {4,4,6,5,3,2,8,1};
        System.out.println("doubleQuickSortTest array : "+ Arrays.toString(array));
        QuickSort.doubleCirculationSort(array,0,array.length-1);
        System.out.println("doubleQuickSortTest sort : "+ Arrays.toString(array));
    }

    @Test
    public void unilateralQuickSortTest(){
        int []array = {4,4,6,5,3,2,8,1};
        System.out.println("unilateralQuickSortTest array : "+ Arrays.toString(array));
        QuickSort.unilateralCirculationSort(array,0,array.length-1);
        System.out.println("unilateralQuickSortTest sort : "+ Arrays.toString(array));
    }

    @Test
    public void unilateralQuickSortByStackTest(){
        int []array = {4,4,6,5,3,2,8,1};
        System.out.println("unilateralQuickSortByStackTest array : "+ Arrays.toString(array));
        QuickSort.unilateralCirculationSortByStack(array,0,array.length-1);
        System.out.println("unilateralQuickSortByStackTest sort : "+ Arrays.toString(array));
    }

    @Test
    public void otherTest(){
        int []array1 = {4,4,6,5,3,2,8,1};
        System.out.println("OtherTest array : "+ Arrays.toString(array1));
        TheQuickSort.doubleQuickSort(array1,0,array1.length-1);
        System.out.println(" array1 : "+ Arrays.toString(array1));
        int []array2 = {4,4,6,5,3,2,8,1};
        TheQuickSort.unilateralQuickSort(array2,0,array2.length-1);
        System.out.println(" array2 : "+ Arrays.toString(array2));
        int []array3 = {4,4,6,5,3,2,8,1};
        TheQuickSort.unilateralQuickSortByStack(array3,0,array3.length-1);
        System.out.println(" array3 : "+ Arrays.toString(array3));
    }
}
