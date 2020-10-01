package com.tinyorangecat.algorithm.sort.test;

import com.tinyorangecat.algorithm.sort.BubbleSort;
import com.tinyorangecat.algorithm.sort.CocktailSort;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    private void bubbleSort(int []array){
        int lastExchangeIndex = 0;
        int setBorder = array.length - 1;
        for(int i = 0;i <array.length;i++){
            boolean isSorted = true;
            for(int j = 0;j < setBorder;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            setBorder = lastExchangeIndex;
            if(isSorted){
                break;
            }
        }
    }

    private void cocktailSort(int []array){
        for(int i = 0;i < array.length/2;i++){
            boolean isSorted = true;
            for(int j = i;j < array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
            isSorted = true;
            for(int j = array.length-i-1;j > 0;j--){
                if(array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                }
            }
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
        bubbleSort(array);
        System.out.println("Local-Bubble-sort--Ordered array : "+Arrays.toString(array));
    }

    @Test
    public void cocktailSortTest(){
        int []array ={9,8,2,10,45,5,6,4};
        System.out.println("Cocktail--Unordered array : "+ Arrays.toString(array));
        CocktailSort.sort(array);
        System.out.println("Cocktail-sort--Ordered array : "+Arrays.toString(array));
    }

    @Test
    public void localCocktailSortTest(){
        int []array ={9,8,2,10,45,5,6,4};
        System.out.println("Local-Cocktail--Unordered array : "+ Arrays.toString(array));
        cocktailSort(array);
        System.out.println("Local-Cocktail-sort--Ordered array : "+Arrays.toString(array));
    }
}
