package com.tinyorangecat.algorithm.interview.test;

public class ReviewDeleteKNumber {

    public static String removeKNumber(String num,int k){
        if(k >= num.length()){
            return "0";
        }
        int newLength = num.length()-k;
        char []numTemp = new char[newLength];
        int top = 0;
        for(int i = 0;i < num.length();i++){
            char c = num.charAt(i);
            while (k > 0 && top > 0 && numTemp[top - 1] > c){
                top -= 1;
                k -= 1;
            }
            numTemp[top++] = c;
        }
        int offset = 0;
        while (newLength > offset && numTemp[offset] == '0'){
            offset++;
        }
        return new String(numTemp,offset,newLength - offset);
    }
}
