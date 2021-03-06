package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.GreatestCommonDivisor;
import org.junit.Test;

public class GreatestCommonDivisorTest {

    @Test
    public void getGreatestCommonDivisor1Test(){
        int a = 100;
        int b = 50;

        System.out.println("1-The greatest common Divisor of "+a+" and "+b+" is :"+ GreatestCommonDivisor.getGreatestCommonDivisor1(a, b));
    }

    @Test
    public void getGreatestCommonDivisor2Test(){
        int a = 100;
        int b = 50;

        System.out.println("2-The greatest common Divisor of "+a+" and "+b+" is :"+ GreatestCommonDivisor.getGreatestCommonDivisor2(a, b));
    }

    @Test
    public void getGreatestCommonDivisor3Test(){
        int a = 100;
        int b = 50;

        System.out.println("3-The greatest common Divisor of "+a+" and "+b+" is :"+ GreatestCommonDivisor.getGreatestCommonDivisor3(a, b));
    }

    @Test
    public void getGreatestCommonDivisor4Test(){
        int a = 100;
        int b = 50;

        System.out.println("4-The greatest common Divisor of "+a+" and "+b+" is :"+ GreatestCommonDivisor.getGreatestCommonDivisor4(a, b));
    }

    @Test
    public void reviewTest(){
        int a = 100;
        int b = 50;
        System.out.println("The greatest common Divisor of "+a+" and "+b+" is :"+ReviewBiggestCommonDivisor.getTheBiggestCommonDivisor(a, b));
        System.out.println("V1:The greatest common Divisor of "+a+" and "+b+" is :"+ReviewBiggestCommonDivisor.getTheBiggestCommonDivisorV1(a, b));
        System.out.println("V2:The greatest common Divisor of "+a+" and "+b+" is :"+ReviewBiggestCommonDivisor.getTheBiggestCommonDivisorV2(a, b));
        System.out.println("V3:The greatest common Divisor of "+a+" and "+b+" is :"+ReviewBiggestCommonDivisor.getTheBiggestCommonDivisorV3(a, b));
    }
}
