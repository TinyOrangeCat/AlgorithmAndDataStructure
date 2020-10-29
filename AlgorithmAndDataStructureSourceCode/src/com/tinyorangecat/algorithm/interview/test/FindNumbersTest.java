package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.FindNumbers;
import org.junit.Test;

import java.util.Arrays;

public class FindNumbersTest {

    @Test
    public void findLostNumbersTest(){
        int []array = {4,1,2,2,5,1,4,3};
        int number = 2;
        System.out.println("Array "+ Arrays.toString(array)+" ,the numbers of odd occurrences is : "+ Arrays.toString(FindNumbers.findLostNumbers(array,number)));
    }

    @Test
    public void reviewTest(){
        int []array = {4,1,2,2,5,1,4,3};
        int number = 2;
        System.out.println("Review : Array "+ Arrays.toString(array)+" ,the numbers of odd occurrences is : "+ Arrays.toString(ReviewFindNumber.findNumber(array,number)));
    }
}
