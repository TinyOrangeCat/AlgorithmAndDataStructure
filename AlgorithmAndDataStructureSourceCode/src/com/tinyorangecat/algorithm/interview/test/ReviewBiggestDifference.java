package com.tinyorangecat.algorithm.interview.test;

public class ReviewBiggestDifference {
    private static class Bucket{
        Integer min;
        Integer max;
    }
    public static Integer getTheBiggestDifferences(int []arrayNum){
        if(arrayNum == null){
            return null;
        }
        int max = arrayNum[0];
        int min = arrayNum[0];
        for(int i = 0;i < arrayNum.length;i++){
            if(arrayNum[i] > max){
                max = arrayNum[i];
            }
            if(arrayNum[i] < min){
                min = arrayNum[i];
            }
        }
        int d = max - min;
        if(d == 0){
            return null;
        }
        int bucketNum = arrayNum.length;
        Bucket []buckets = new Bucket[bucketNum];
        for(int i = 0;i < buckets.length;i++){
            buckets[i] = new Bucket();
        }
        for(int i = 0;i < arrayNum.length;i++){
            int index = (arrayNum[i]-min)*(bucketNum-1)/d;
            if(buckets[index].min == null || buckets[index].min > arrayNum[i]){
                buckets[index].min = arrayNum[i];
            }
            if(buckets[index].max == null || buckets[index].max < arrayNum[i]){
                buckets[index].max = arrayNum[i];
            }
        }
        int bigDifferences = 0;
        int leftMax = buckets[0].max;
        for(int i = 1;i < buckets.length;i++){
            if(buckets[i].min == null){
                continue;
            }
            if(buckets[i].min - leftMax > bigDifferences){
                bigDifferences = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return bigDifferences;
    }
}
