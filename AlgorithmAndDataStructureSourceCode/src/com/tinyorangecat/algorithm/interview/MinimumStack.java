package com.tinyorangecat.algorithm.interview;

import java.util.Stack;

public class MinimumStack {
    static Stack<Integer> mainStack = new Stack<Integer>();//主栈
    static Stack<Integer> minStack = new Stack<Integer>();//最小栈

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/2 13:59
     * @Description Enter into a stack.
     * @Param data
     * @Return
     **/
    public void push(int data){
        mainStack.push(data);//所有元素均进主栈
        //若最小栈顶元素大于当前元素，则该元素也应该进最小栈
        if(minStack.isEmpty() || minStack.peek() > data){
            minStack.push(data);
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/2 13:55
     * @Description Pop a stack.
     * @Return
     **/
    public Integer pop(){
        //主栈栈顶元素与最小栈栈顶元素相同，则最小栈也应出栈
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/2 13:56
     * @Description Get the smallest data in stack.
     * @Param
     * @Return int
     **/
    public Integer getMin() throws Exception{
        if(minStack.isEmpty()){
            throw new IndexOutOfBoundsException("最小栈为空！");
        }
        return minStack.peek();
    }

    public void output(){
        System.out.print("The MainStack:");
        Stack<Integer> temp = mainStack;
        while (!temp.isEmpty()){
            System.out.print(temp.pop()+" ");
        }
        System.out.println();
        System.out.print("The MinStack:");
        temp = minStack;
        while (!temp.isEmpty()){
            System.out.print(temp.pop()+" ");
        }
        System.out.println();
    }

}
