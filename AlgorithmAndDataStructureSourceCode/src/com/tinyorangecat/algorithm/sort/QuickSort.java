package com.tinyorangecat.algorithm.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSort {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/30 16:50
     * @Description Sort the arrays form small to large by quick sort(Double Circulation).
     * @Param array
     * @Param startIndex
     * @Param endIndex
     * @Return
     **/
    public static void doubleCirculationSort(int []array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = doublePartition(array,startIndex,endIndex);
        doubleCirculationSort(array,startIndex,pivotIndex - 1);
        doubleCirculationSort(array,pivotIndex + 1,endIndex);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/30 17:09
     * @Description Divide the array to quick sort((Double Circulation)).
     * @Param
     * @Return
     **/
    private static int doublePartition(int []array,int startIndex,int endIndex){
        //双边循环法
        int pivot = array[startIndex];//选取头元素作为基准数
        int leftPointer = startIndex;
        int rightPinter = endIndex;
        while (leftPointer != rightPinter){//左、右指针不重合，数组未遍历完毕
            while (leftPointer < rightPinter && array[rightPinter]>pivot){//先操作右指针左移
                rightPinter--;
            }
            while (leftPointer < rightPinter && array[leftPointer] <= pivot){//操作左指针右移
                leftPointer++;
            }
            if(leftPointer < rightPinter){
                int temp = array[rightPinter];
                array[rightPinter] = array[leftPointer];
                array[leftPointer] = temp;
            }
        }
        //左、右指针重合，交换指针位置元素与头元素
        array[startIndex] = array[leftPointer];
        array[leftPointer] = pivot;
        return leftPointer;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/30 18:31
     * @Description Sort the arrays form small to large by quick sort(Unilateral Circulation).
     * @Param array
     * @Param startIndex
     * @Param endIndex
     * @Return
     **/
    public static void unilateralCirculationSort(int []array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = unilateralPartition(array,startIndex,endIndex);
        unilateralCirculationSort(array,startIndex,pivotIndex-1);
        unilateralCirculationSort(array,pivotIndex+1,endIndex);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/30 18:36
     * @Description Divide the array to quick sort((Unilateral Circulation)).
     * @Param
     * @Return
     **/
    private static int unilateralPartition(int []array,int startIndex,int endIndex){
        //单边循环法
        int pivot = array[startIndex];
        int mark = startIndex;
        for(int i = startIndex;i <= endIndex;i++){
            if(array[i] < pivot){
                mark++;//指针右移
                //指针位置与对比位置交换
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        //数组遍历一轮结束，指针位置数据与基准数交换
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void unilateralCirculationSortByStack(int []array,int startIndex,int endIndex){
        //使用非递归的方式实现单边循环快速查找
        Stack<Map<String,Integer>> quickSortStack = new Stack<Map<String,Integer>>();
        Map<String,Integer> indexMap = new HashMap<String,Integer>();
        indexMap.put("startIndex",startIndex);
        indexMap.put("endIndex",endIndex);
        quickSortStack.push(indexMap);
        while (!quickSortStack.isEmpty()){
            Map<String,Integer> paramMap = quickSortStack.pop();
            int pivotIndex = unilateralPartition(array,paramMap.get("startIndex"),paramMap.get("endIndex"));
            if(paramMap.get("startIndex") < pivotIndex - 1){
                Map<String,Integer> leftParam = new HashMap<String,Integer>();
                leftParam.put("startIndex",paramMap.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if(paramMap.get("endIndex") > pivotIndex + 1){
                Map<String,Integer> rightParam = new HashMap<String,Integer>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",paramMap.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }
}
