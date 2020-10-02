package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.MinimumStack;
import org.junit.Test;

public class MinimumStackTest {

    private MinimumStack buildMinimumStack(){
        MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(4);
        minimumStack.push(9);
        minimumStack.push(7);
        minimumStack.push(3);
        minimumStack.push(8);
        minimumStack.push(5);
        return minimumStack;
    }

    @Test
    public void pushStackTest(){
        MinimumStack minimumStack = buildMinimumStack();
        minimumStack.output();
    }

    @Test
    public void popStackTest(){
        MinimumStack minimumStack = buildMinimumStack();
        System.out.println("get Stack pop:"+minimumStack.pop());
    }

    @Test
    public void getMinStackTest()throws Exception{
        MinimumStack minimumStack = buildMinimumStack();
        //minimumStack.output();
        System.out.println("get min in Stack:"+minimumStack.getMin());
        minimumStack.push(2);
        System.out.println("get min in Stack:"+minimumStack.getMin());
        System.out.println("get Stack pop:"+minimumStack.pop());
        System.out.println("get min in Stack:"+minimumStack.getMin());
    }
}
