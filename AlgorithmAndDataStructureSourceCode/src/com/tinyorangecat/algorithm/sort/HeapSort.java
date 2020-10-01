package com.tinyorangecat.algorithm.sort;

public class HeapSort {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/1 13:24
     * @Description Sort the arrays from large to small by heap sort.
     * @Param array
     * @Return void
     **/
    public static void sort(int []array){
        //从大到小进行堆排序
        for(int i = (array.length - 2)/2;i >= 0;i--){
            goDown(array,i,array.length);//建最小堆
        }
        //堆顶最小的数置于数组末尾，并重新建最小堆
        for(int i = array.length - 1;i > 0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            goDown(array,0,i);
        }

    }

    private static void goDown(int []array,int parentIndex,int length){
        int childIndex = parentIndex*2+1;
        int temp = array[parentIndex];
        while(childIndex < length){
            if(childIndex+1 < length && array[childIndex+1] < array[childIndex]){
                childIndex++;
            }
            if(temp <= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = temp;
    }
}
