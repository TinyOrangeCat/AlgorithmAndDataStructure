package com.tinyorangecat.algorithm.interview.test;

public class ReviewPowerOf2 {

    public static boolean isPowerOf2V1(int num){
        int temp = 1;
        while (temp <= num){
            if(temp == num){
                return true;
            }
            temp *= 2;
        }
        return false;
    }

    public static boolean isPowerOf2V2(int num){
        int temp = 1;
        while (temp <= num){
            if(temp == num){
                return true;
            }
            temp <<= 1;
        }
        return false;
    }

    public static boolean isPowerOf2V3(int num){
        return (num&num-1)==0;
    }
}
