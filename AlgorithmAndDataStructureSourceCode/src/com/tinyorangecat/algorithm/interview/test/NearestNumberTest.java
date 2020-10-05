package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.NearestNumber;
import org.junit.Test;

import java.util.Arrays;

public class NearestNumberTest {

    @Test
    public void findNearestNumberTest(){
        int num = 12345;
        System.out.println("findNearestNumberTest num = "+num);
        System.out.println("The Nearest Number num = "+ NearestNumber.findNearestNumber(num));
    }
}
