package com.tinyorangecat.algorithm.sort;

public class CountSort {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/1 14:52
     * @Description Sort the arrays from large to small by count sort.
     * @Param array
     * @Return void
     **/
    public static void sort(int []array){
        //从大到小进行堆排序
        //得到最大元素
        int biggest = array[0];
        for(int i = 0;i < array.length;i++){
            if(array[i]>biggest){
                biggest = array[i];
            }
        }
        int []countArray = new int[biggest+1];//计数数组
        for(int i = 0;i < array.length;i++){
            countArray[array[i]]++;
        }
        //遍历计数数组，将不为0的计数数组下标转存到结果数组
        int index = 0;
        for(int i = countArray.length-1;i >= 0;i--){
            for(int j = 0;j < countArray[i];j++){
                array[index++] = i;
            }
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/1 15:40
     * @Description Sort the arrays from large to small by the improved count sort(minimize the space and keep the array order).
     * @Param array
     * @Return void
     **/
    public static int[] improveSort(int []array){
        //从小到大排序
        int biggest = array[0];
        int smallest = array[0];//偏移量
        for(int i = 0;i < array.length;i++){
            if(array[i]>biggest){
                biggest = array[i];
            }
            if(array[i] < smallest){
                smallest = array[i];
            }
        }
        int []countArray = new int[biggest-smallest+1];
        for(int i = 0;i < array.length;i++){
            countArray[(array[i]-smallest)]++;
        }
        //从数组1下标开始，计数数组值两两相加
        for(int i = 1;i < countArray.length;i++){
            countArray[i] = countArray[i]+countArray[i-1];
        }
        int []resultArray = new int[array.length];
        //countArray中的数就是对应array中每个数的排序次序
        for(int i = 0;i < array.length;i++){
            resultArray[countArray[array[i]-smallest]-1] = array[i];
            countArray[array[i]-smallest]--;//countArray对应位置下存的一组数少一个
        }
        return resultArray;
    }
}
