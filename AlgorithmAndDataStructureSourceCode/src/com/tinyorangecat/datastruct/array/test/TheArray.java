package com.tinyorangecat.datastruct.array.test;

public class TheArray {
    private int []array;
    private int size;

    public TheArray(int capacity){
        this.array = new int[capacity];
    }

    public void insertArray(int index,int data)throws Exception{
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("The Array数组越界！！");
        }
        if(size >= array.length){
            expansion();
        }
        for(int i = size - 1;i >= index;i--){
            array[i+1] = array[i];
        }
        array[index] = data;
        size++;
    }

    private void expansion(){
        int []newArray = new int[this.size*2];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    public int deleteArray(int index)throws Exception{
        if(index >= size || index < 0){
            throw new IndexOutOfBoundsException("The Array数组越界！！");
        }
        int deletedData = array[index];
        for(int i = index;i < size - 1;i++){
            array[i] = array[i+1];
        }
        size--;
        return deletedData;
    }

    public void output(){
        System.out.println("The array size is : "+size);
        System.out.print("The array is : [");
        for(int i = 0;i < size;i++){
            System.out.print(array[i]);
            if(i < size-1){
                System.out.print(",");
            }
        }
        System.out.println("].");
    }
}
