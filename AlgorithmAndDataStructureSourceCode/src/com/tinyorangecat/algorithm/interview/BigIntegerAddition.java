package com.tinyorangecat.algorithm.interview;

public class BigIntegerAddition {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/6 11:37
     * @Description Get the two integers addition result.
     * @Param a
     * @Param b
     * @Return String
     **/
    public static String bigIntegerAddition(String a,String b){
        int maxLength = a.length() > b.length() ? a.length() : b.length();
        //将大数存入数组中（最左边的数是大数的最低位数）
        int []newArrayA = new int[maxLength+1];
        for(int i = 0;i < a.length();i++){
            newArrayA[i] = a.charAt(a.length()-i-1)-'0';
        }
        int []newArrayB = new int[maxLength+1];
        for(int i = 0;i < b.length();i++){
            newArrayB[i] = b.charAt(b.length()-i-1)-'0';
        }
        //对两个数组从左到右进行相加
        int []result = new int[maxLength + 1];
        for(int i = 0;i < result.length;i++){
            int temp = result[i];
            temp += newArrayA[i];
            temp += newArrayB[i];
            if(temp >= 10){
                result[i+1] = result[i+1]+1;
                temp -= 10;
            }
            result[i] = temp;
        }
        //拼相加结果
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = false;
        for(int i = result.length-1;i >= 0;i--){
            if(!isFirst){
                if(result[i]==0){
                    continue;
                }
                isFirst = true;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
}
