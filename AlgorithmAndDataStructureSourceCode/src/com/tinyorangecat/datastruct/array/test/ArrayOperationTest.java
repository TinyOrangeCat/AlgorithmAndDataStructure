package com.tinyorangecat.datastruct.array.test;


import com.tinyorangecat.datastruct.array.MyArray;
import org.junit.Test;

public class ArrayOperationTest {

    @Test
    public void arrayInsertTest() throws Exception {
        MyArray array = new MyArray(10);
        array.insertArray(1,3);
        array.insertArray(2,1);
        array.insertArray(3,2);
        array.insertArray(4,5);
        array.insertArray(5,4);
        array.insertArray(6,9);
        array.insertArray(3,10);
        array.output();
    }
}
