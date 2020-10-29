package com.tinyorangecat.algorithm.interview.test;

public class ReviewFindNumber {

    public static int[] findNumber(int []array,int count){
        int xorResult = 0;
        for(int i = 0;i < array.length;i++){
            xorResult ^= array[i];
        }
        if(xorResult == 0){
            return null;
        }
        int []result = new int[count];
        int xorSeparator = 1;
        while (0 == (xorResult&xorSeparator)){
            xorSeparator <<= 1;
        }
        for(int i = 0;i < array.length;i++){
            if((xorSeparator & array[i]) == 0){
                result[0] ^= array[i];
            }else {
                result[1] ^= array[i];
            }
        }
        return result;
    }
}
