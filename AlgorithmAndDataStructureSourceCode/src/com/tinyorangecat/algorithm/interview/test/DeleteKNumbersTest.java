package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.DeleteKNumbers;
import org.junit.Test;

public class DeleteKNumbersTest {
    @Test
    public void deleteKNumbersTest1(){
        String num = "1593212";
        int k = 3;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
        num = "30200";
        k = 1;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
        num = "10";
        k = 2;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
        num = "541270936";
        k = 3;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
    }

    @Test
    public void deleteKNumbersTest2(){
        String num = "541270936";
        int k = 3;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
        /*num = "30200";
        k = 1;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
        num = "10";
        k = 2;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));
        num = "541270936";
        k = 3;
        System.out.println("The Number "+num+" deleted "+k+" digits is "+ DeleteKNumbers.removeKNumbersResult(num,k));*/
    }

    @Test
    public void reviewTest(){
        String num = "541270936";
        int k = 3;
        System.out.println("Review:The Number "+num+" deleted "+k+" digits is "+ ReviewDeleteKNumber.removeKNumber(num,k));
    }
}
