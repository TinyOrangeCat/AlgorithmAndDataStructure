package com.tinyorangecat.algorithm.interview;

public class DeleteKNumbers {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/5 14:38
     * @Description Delete k numbers from a number and get the smallest result。
     * @Param num
     * @Param k
     * @Return
     **/
    public static String removeKNumbersResult(String num,int k){
        if(k >= num.length()){
            return "0";
        }
        int newLength = num.length()-k;
        char []charStack = new char[newLength];
        int top = 0;
        for(int i = 0;i < num.length();++i){
            char c = num.charAt(i);
            while (top > 0 && charStack[top-1] > c && k > 0){
                top -= 1;
                k -=1;
            }
            charStack[top++] = c;
        }
        //记录开头有多少个0
        int offset = 0;
        while (offset < newLength && charStack[offset] == '0'){
            offset++;
        }
        return offset == newLength ? "0" : new String(charStack,offset,newLength-offset);
    }
}
