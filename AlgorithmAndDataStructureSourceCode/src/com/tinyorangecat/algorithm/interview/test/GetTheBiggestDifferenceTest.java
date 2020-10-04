package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.GetTheBiggestDifference;
import org.junit.Test;

import java.util.Arrays;

public class GetTheBiggestDifferenceTest {
    @Test
    public void getTheTheBiggestSortedDifferenceTest(){
        int []array = {2,6,3,4,5,10,9};
        System.out.println("Array is : "+ Arrays.toString(array));
        System.out.println("The Biggest Difference in the array is : "+ GetTheBiggestDifference.getTheTheBiggestSortedDifference(array));
    }
}
