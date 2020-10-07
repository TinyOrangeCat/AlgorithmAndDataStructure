package com.tinyorangecat.algorithm.interview.test;

import java.util.Stack;

public class ReviewMinimumStack {

    private static Stack<Integer> mainStack = new Stack<Integer>();
    private static Stack<Integer> miniStack = new Stack<Integer>();

    public void push(Integer num){
        if(miniStack.isEmpty() || miniStack.peek() > num){
            miniStack.push(num);
        }
        mainStack.push(num);
    }
    public Integer pop(){
        if(mainStack.peek().equals(miniStack.peek())){
            miniStack.pop();
        }
        return mainStack.pop();
    }
    public Integer getMin(){
        if(!miniStack.isEmpty()){
            return miniStack.peek();
        }
        return null;
    }
}
