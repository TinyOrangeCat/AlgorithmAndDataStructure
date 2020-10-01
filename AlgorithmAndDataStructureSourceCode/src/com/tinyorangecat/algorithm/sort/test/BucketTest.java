package com.tinyorangecat.algorithm.sort.test;

import com.tinyorangecat.algorithm.sort.BucketSort;
import org.junit.Test;

import java.util.Arrays;

public class BucketTest {

    @Test
    public void bucketTest(){
        double []array = {4.12,6.214,0.0023,3.0,2.123,8.122,4.12,10.09};
        System.out.println("bucketTest double array : "+ Arrays.toString(array));
        BucketSort.sort(array);
        System.out.println("bucketTest sort array : "+ Arrays.toString(array));
    }
}
