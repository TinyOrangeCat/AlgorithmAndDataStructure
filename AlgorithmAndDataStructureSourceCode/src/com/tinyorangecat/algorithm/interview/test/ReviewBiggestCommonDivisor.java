package com.tinyorangecat.algorithm.interview.test;

public class ReviewBiggestCommonDivisor {

    public static int getTheBiggestCommonDivisorV1(int a,int b){
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big % small == 0){
            return small;
        }
        for(int i = small/2;i >= 1;i++){
            if(big % i == 0 && small % i == 0){
                return i;
            }
        }
        return 1;
    }

    public static int getTheBiggestCommonDivisorV2(int a,int b){
        //辗转相除法
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big % small == 0){
            return small;
        }
        return getTheBiggestCommonDivisorV2(big % small,small);
    }

    public static int getTheBiggestCommonDivisorV3(int a,int b){
        //更相减损法
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big % small == 0){
            return small;
        }
        return getTheBiggestCommonDivisorV2(big - small,small);
    }

    public static int getTheBiggestCommonDivisor(int a,int b){
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if(big % small == 0){
            return small;
        }
        if((big & 1) == 0 && (small & 1) == 0){
            return getTheBiggestCommonDivisor(big >> 1,small >> 1)<<1;
        }else if((big & 1) != 0 && (small & 1) == 0){
            return getTheBiggestCommonDivisor(big << 1,small);
        }else if((big & 1) == 0 && (small & 1) != 0){
            return getTheBiggestCommonDivisor(big,small<<1);
        }else{
            return getTheBiggestCommonDivisor(big - small ,small);
        }
    }
}
