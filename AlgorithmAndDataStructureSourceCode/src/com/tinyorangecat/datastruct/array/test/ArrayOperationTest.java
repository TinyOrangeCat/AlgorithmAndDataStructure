package com.tinyorangecat.datastruct.array.test;


import com.tinyorangecat.datastruct.array.MyArray;
import org.junit.Test;

public class ArrayOperationTest {

    private MyArray buildArray() throws Exception{
        MyArray array = new MyArray(5);
        array.insertArrayFromZero(0,3);
        array.insertArrayFromZero(1,1);
        array.insertArrayFromZero(2,2);
        array.insertArrayFromZero(3,5);
        array.insertArrayFromZero(4,4);
        array.insertArrayFromZero(5,9);
        return array;
    }
    @Test
    public void arrayInsertTest() throws Exception {
        MyArray array = new MyArray(5);
        array.insertArray(1,3);
        array.insertArray(2,1);
        array.insertArray(3,2);
        array.insertArray(4,5);
        array.insertArray(5,4);
        array.insertArray(6,9);
        array.output();
        array.insertArray(1,10);
        array.output();
    }

    @Test
    public void arrayInsertFromZeroTest() throws Exception {
        MyArray array = buildArray();
        array.insertArrayFromZero(0,10);
        array.output();
    }

    @Test
    public void arrayDeleteFormZeroTest()throws Exception{
        MyArray array = buildArray();
        array.output();
        System.out.println("Array position 5 is element : "+array.deleteArrayFromZero(5));
        //array.deleteArrayFromZero(2);
        array.output();
    }

    @Test
    public void arrayDeleteTest()throws Exception{
        MyArray array = buildArray();
        array.output();
        System.out.println("Array position 6 is element : "+array.deleteArray(6));
        //array.deleteArray(2);
        array.output();
    }
}
