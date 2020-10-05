package com.tinyorangecat.algorithm.interview;

import java.util.Arrays;

public class NearestNumber {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/5 11:22
     * @Description Based on the given number,find a nearest number.
     * @Param num
     * @Return int
     **/
    public static Integer findNearestNumber(int num){
        int []numbers;
        String numTemp = String.valueOf(num);
        numbers = new int[numTemp.length()];
        //数字转换为数组更好操作
        for(int i = 0;i < numTemp.length();i++){
            numbers[i] = Integer.valueOf(numTemp.charAt(i)-'0');
        }

        //找到数字交换的边界
        int index = findTransferBorder(numbers);
        if(index == 0){
            return null;
        }
        //交换数字
        exchangeNumber(numbers,index);
        //将倒序数字换为正序
        reverse(numbers,index);
        return output(numbers);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/5 11:40
     * @Description
     * @Param numbers
     * @Return int
     **/
    private static int findTransferBorder(int []numbers){
        for(int i = numbers.length-1;i > 0;i--){
            if(numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/5 11:49
     * @Description
     * @Param numbers
     * @Param index
     * @Return
     **/
    private static void exchangeNumber(int []numbers,int index){
        int head = numbers[index-1];
        for(int i = numbers.length-1;i > 0;i--){
            if(numbers[i] > head){
                numbers[index-1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/5 12:00
     * @Description
     * @Param numbers
     * @Param index
     * @Return
     **/
    private static void reverse(int []numbers,int index){
        for(int i = index,j = numbers.length-1;i < j;i++,j--){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/5 12:04
     * @Description
     * @Param numbers
     * @Return
     **/
    private static Integer output(int []numbers){
        Integer result = 0;
        int power = numbers.length-1;
        for(int i = 0;i < numbers.length;i++){
            int temp = (int)Math.pow(10,power);
            result += (numbers[i]*temp);
            power--;
        }
        return  result;
    }
}
