package com.tinyorangecat.algorithm.interview;

public class FindNumbers {
    
    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/6 14:51
     * @Description Find the numbers of odd occurrences from an array.
     * @Param num
     * @Param resultNum
     * @Return 
     **/
    public static int[] findLostNumbers(int []num,int resultNum){
        int []result = new int[resultNum];
        int xorResult = 0;
        for(int i = 0;i < num.length;i++){
            xorResult ^= num[i];
        }
        //异或结果为0，说明不存在两个奇数次数的数
        if(xorResult == 0){
            return null;
        }
        //确定两个数的不同位
        int xorSeparator = 1;
        while (0 == (xorSeparator&xorResult)){
            xorSeparator <<= 1;
        }
        for(int i = 0;i < num.length;i++){
            if(0 == (num[i]&xorSeparator)){
                result[0] ^= num[i];
            }else {
                result[1] ^= num[i];
            }
        }
        return result;
    }
}
