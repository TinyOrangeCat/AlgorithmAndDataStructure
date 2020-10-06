package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.BigIntegerAddition;
import org.junit.Test;

public class BigIntegerAdditionTest {

    @Test
    public void bigIntegerAdditionTest(){
        String a = "12345678";
        String b = "78946512351356";
        System.out.println(a+" add "+b+" is : "+ BigIntegerAddition.bigIntegerAddition(a,b));
    }
}
