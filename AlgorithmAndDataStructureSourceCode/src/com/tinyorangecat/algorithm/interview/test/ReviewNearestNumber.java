package com.tinyorangecat.algorithm.interview.test;

public class ReviewNearestNumber {

    public static Integer findNearestNumber(int num){
        String numString = String.valueOf(num);
        int []numArray = new int[numString.length()];
        for(int i = 0;i < numArray.length;i++){
            numArray[i] = numString.charAt(i)-'0';
        }
        int index = findExchangeIndex(numArray);

        exchangeNumber(numArray,index);
        reverse(numArray,index);
        return output(numArray);
    }

    private static int findExchangeIndex(int []num){
        for(int i = num.length-1;i > 0;i--){
            if(num[i-1] < num[i]){
                return i;
            }
        }
        return 0;
    }

    private static void exchangeNumber(int []num,int index){
        int head = num[index-1];
        for(int i = num.length - 1;i > 0;i--){
            if(num[i] > head){
                num[index-1] = num[i];
                num[i] = head;
                break;
            }
        }
    }

    private static void reverse(int []num,int index){
        for(int i = index,j = num.length-1;j > i;j--,i++){
            int temp = num[i];
            num[i] = num[i-1];
            num[i-1] = temp;
        }
    }

    private static Integer output(int []num){
        int zeroCount = num.length-1;
        int result = 0;
        for(int i = 0;i < num.length;i++){
            result += ((int)Math.pow(10,zeroCount)*num[i]);
            zeroCount--;
        }
        return result;
    }
}
