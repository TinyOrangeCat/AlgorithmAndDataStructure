package com.tinyorangecat.algorithm.interview.test;

public class ReviewBigNumberAdd {

    public static String bigNumberAdd(String numberA,String numberB){
        int bigLength = numberA.length() > numberB.length() ? numberA.length() : numberB.length();
        int []tempA = new int[bigLength+1];
        for(int i = 0;i < numberA.length();i++){
            tempA[i] = numberA.charAt(numberA.length()-1-i)-'0';
        }
        int []tempB = new int[bigLength+1];
        for(int i = 0;i < numberB.length();i++){
            tempB[i] = numberB.charAt(numberB.length()-1-i)-'0';
        }
        int []tempResult = new int[bigLength+1];
        for(int i = 0;i < bigLength;i++){
            int temp = tempResult[i];
            temp += tempA[i];
            temp += tempB[i];
            if(temp >= 10){
                tempResult[i+1] = 1;
                temp -= 10;
            }
            tempResult[i] = temp;
        }
        StringBuilder builder = new StringBuilder();
        boolean isFirst = false;
        for(int i = tempResult.length-1;i >= 0;i--){
            if(!isFirst){
                if(tempResult[i] == 0){
                    continue;
                }
                isFirst = true;
            }
            builder.append(tempResult[i]);
        }
        return builder.toString();
    }
}
