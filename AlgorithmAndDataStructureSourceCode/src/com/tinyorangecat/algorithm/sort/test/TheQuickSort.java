package com.tinyorangecat.algorithm.sort.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TheQuickSort {

    public static void doubleQuickSort(int []array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = doubleCirculationPartition(array,startIndex,endIndex);
        doubleQuickSort(array,startIndex,pivotIndex-1);
        doubleQuickSort(array,pivotIndex+1,endIndex);
    }

    private static int doubleCirculationPartition(int []array,int startIndex,int endIndex){
        int pivot = array[startIndex];
        int leftPointer = startIndex;
        int rightPointer = endIndex;
        while (leftPointer != rightPointer){
            while (leftPointer < rightPointer && array[rightPointer] > pivot){
                rightPointer--;
            }
            while (leftPointer < rightPointer && array[leftPointer] <= pivot){
                leftPointer++;
            }
            int temp = array[leftPointer];
            array[leftPointer] = array[rightPointer];
            array[rightPointer] = temp;
        }
        array[startIndex] = array[leftPointer];
        array[leftPointer] = pivot;
        return leftPointer;
    }

    public static void unilateralQuickSort(int []array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = unilateralCirculationPartition(array,startIndex,endIndex);
        unilateralQuickSort(array,startIndex,pivotIndex-1);
        unilateralQuickSort(array,pivotIndex+1,endIndex);
    }

    private static int unilateralCirculationPartition(int []array,int startIndex,int endIndex){
        int mark = startIndex;
        int pivot = array[startIndex];
        for(int i = startIndex+1;i <= endIndex;i++){
            if(array[i] < pivot){
                mark++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void unilateralQuickSortByStack(int []array,int startIndex,int endIndex){
        Stack<Map<String,Integer>> quickSortStack = new Stack<Map<String,Integer>>();
        Map<String,Integer> indexMap = new HashMap<>();
        indexMap.put("startIndex",startIndex);
        indexMap.put("endIndex",endIndex);
        quickSortStack.push(indexMap);
        while (!quickSortStack.isEmpty()){
            Map<String,Integer> paramIndex = quickSortStack.pop();
            int pivotIndex = unilateralCirculationPartition(array,paramIndex.get("startIndex"),paramIndex.get("endIndex"));
            if(paramIndex.get("startIndex") < pivotIndex - 1){
                Map<String,Integer> leftIndex = new HashMap<>();
                leftIndex.put("startIndex",paramIndex.get("startIndex"));
                leftIndex.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftIndex);
            }
            if(paramIndex.get("endIndex") > pivotIndex + 1){
                Map<String,Integer> rightIndex = new HashMap<>();
                rightIndex.put("startIndex",pivotIndex+1);
                rightIndex.put("endIndex",paramIndex.get("endIndex"));
                quickSortStack.push(rightIndex);
            }
        }
    }
}
