package com.tinyorangecat.algorithm.sort;

public class BubbleSort {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/29 11:09
     * @Description Sort arrays from large to small by bubble sort.
     * @Param array The array that need to be sorted.
     * @Return void
     **/
    public static void sort(int []array){
        //从小到大进行冒泡排序
        int lastExchangeIndex = 0;//记录上次交换位置
        int sortBorder = array.length - 1;//进行排序的边界
        for(int i = 0;i < array.length;i++){
            boolean isSorted = true;
            for(int j = 0;j < sortBorder;j++){//冒泡排序已排序过的位置，不需要再进行排序
                if(array[j] > array[j+1]){//前一个数大于后一个数，进行数据交换
                    int tempt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempt;
                    isSorted = false;//记录此次排序是无序的
                    lastExchangeIndex = j;//记录最后交换数据的位置
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){//若上次已是有序状态、没有进行数据换位，则无需进行后续排序
                break;
            }
        }
    }
}
