package com.tinyorangecat.algorithm.sort;

public class CocktailSort {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/30 11:11
     * @Description Sort arrays from large to small by cocktail sort.
     * @Param array The array that needs to be sorted.
     * @Return void
     **/
    public static void sort(int []array){
        //因为是鸡尾酒排序，从左到右，从右到左进行比对，已经对比好的首尾位置不用进行第二次对比，故最终需要比对的次数就就是数组总长的一半
        for (int i = 0;i < array.length/2;i++){
            boolean isSorted = true;
            //左到右
            for(int j = i;j < array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    int tempt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempt;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
            isSorted = true;
            //右到左
            for(int j = array.length-i-1;j > i;j--){
                if(array[j] < array[j-1]){
                    int tempt = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tempt;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

    }
}
