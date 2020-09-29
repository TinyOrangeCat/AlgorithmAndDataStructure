package com.tinyorangecat.algorithm.sort.test;

import com.tinyorangecat.algorithm.sort.BubbleSort;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    private void bubleSort(int []array){
        int lastExchangeIndex = 0;
        int sortBorder = array.length - 1;
        for(int i = 0;i < array.length;i++){
            boolean isSorted = true;
            for(int j = 0;j < sortBorder;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    lastExchangeIndex = j;
                    isSorted = false;
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }

    @Test
    public void bubbleSortTest(){
        int []array ={9,8,2,10,45,5,6,4};
        System.out.println("Bubble-sort--Unordered array : "+ Arrays.toString(array));
        BubbleSort.sort(array);
        System.out.println("Bubble-sort--Ordered array : "+Arrays.toString(array));
    }
    @Test
    public void localBubbleSortTest(){
        int []array ={9,8,2,10,45,5,6,4};
        System.out.println("Local-Bubble-sort--Unordered array : "+ Arrays.toString(array));
        bubleSort(array);
        System.out.println("Local-Bubble-sort--Ordered array : "+Arrays.toString(array));
    }
}
