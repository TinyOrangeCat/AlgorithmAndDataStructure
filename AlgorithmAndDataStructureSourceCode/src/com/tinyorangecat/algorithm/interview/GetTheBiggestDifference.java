package com.tinyorangecat.algorithm.interview;

public class GetTheBiggestDifference {
    private static class Bucket{
        Integer max;
        Integer min;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/4 11:47
     * @Description Get the biggest difference form a sorted array.
     * @Param array
     * @Return
     **/
    public static int getTheTheBiggestSortedDifference(int []array){
        if(array == null){
            return 0;
        }
        int max = array[0];
        int min = array[0];
        for(int i = 0;i < array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        int d = max - min;
        if(d == 0){
            return 0;
        }
        int bucketNum = array.length;
        Bucket []buckets = new Bucket[bucketNum];
        for(int i = 0;i < bucketNum;i++){
            buckets[i] = new Bucket();
        }
        for(int i = 0;i < array.length;i++){
            int index = ((array[i] - min)*(bucketNum - 1)/d);
            if(buckets[index].min == null || buckets[index].min > array[i]){
                buckets[index].min = array[i];
            }
            if(buckets[index].max == null || buckets[index].max < array[i]){
                buckets[index].max = array[i];
            }
        }

        //左桶最大值减去右桶最小值
        int leftMax = buckets[0].max;
        int maxDifference = 0;
        for(int i = 1;i < buckets.length;i++){
            if(buckets[i].min == null){
                continue;
            }
            if(buckets[i].min - leftMax > maxDifference){
                maxDifference = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDifference;
    }
}
