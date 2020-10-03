package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.PowerOf2;
import org.junit.Test;

public class PowerOf2Test {

    @Test
    public void isPowerOf2Test1(){
        int a = 99;
        System.out.println("V1 Number "+a+" is power of 2 = "+ PowerOf2.isPowerOf2V1(a));
        int b = 8;
        System.out.println("V1 Number "+b+" is power of 2 = "+ PowerOf2.isPowerOf2V1(b));
    }

    @Test
    public void isPowerOf2Test2(){
        int a = 99;
        System.out.println("V2 Number "+a+" is power of 2 = "+ PowerOf2.isPowerOf2V2(a));
        int b = 8;
        System.out.println("V2 Number "+b+" is power of 2 = "+ PowerOf2.isPowerOf2V2(b));
    }

    @Test
    public void isPowerOf2Test3(){
        int a = 99;
        System.out.println("V3 Number "+a+" is power of 2 = "+ PowerOf2.isPowerOf2V3(a));
        int b = 8;
        System.out.println("V3 Number "+b+" is power of 2 = "+ PowerOf2.isPowerOf2V3(b));
    }
}
