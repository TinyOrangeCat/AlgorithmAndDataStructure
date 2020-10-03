package com.tinyorangecat.algorithm.interview;

public class PowerOf2 {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 13:57
     * @Description Judge a integer is power of 2 or not.
     * @Param num
     * @Return
     **/
    public static boolean isPowerOf2V1(int num){
        //T(n) = O(logn)
        int temp = 1;
        while(temp <= num){
            if (temp == num){
                return true;
            }
            temp *= 2;
        }
        return false;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 14:04
     * @Description Judge a integer is power of 2 or not by left offset.
     * @Param num
     * @Return
     **/
    public static boolean isPowerOf2V2(int num){
        //T(n) = O(logn)
        int temp = 1;
        while(temp <= num){
            if (temp == num){
                return true;
            }
            temp <<= 1;
        }
        return false;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 14:06
     * @Description Judge a integer is power of 2 or not by binary.
     * @Param
     * @Return
     **/
    public static boolean isPowerOf2V3(int num){
        //T(n) = O(1)
        //所有2的整数次幂的二进制最高位为1，其他位均为0，且其二进制数减1后所有位均为1。
        return (num&num-1)==0;
    }
}
