package com.tinyorangecat.datastruct.array;


public class MyArray {

    private int []array;
    private int size;


    public MyArray(int capacity){
        this.array = new int[capacity];
        this.size = 0;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/22 20:22
     * @Description Insert a data into array.
     * @Param index The position in array(starts with 1).
     * @Param element The data(should be the type of int) which needs to be inserted.
     * @Return void
     **/
    public void insertArray(int index,int element)throws Exception{
        //从数组的位置“1”开始（也就是从Java数组下标为0的位置）插入数据，并且数组是顺序存储
        if(index < 1 || index > (size+1)){
            throw new ArrayIndexOutOfBoundsException("数组越界！");
        }
        //数组达到最大容量时，进行扩容
        if(size >= array.length){
            arrayExpansion();
        }
        //从后往前，将数据后移一位，为需要插入的数据空出位置
        for(int i = size-1;i >= index-1;i--){
            array[i+1] = array[i];
        }
        array[index-1] = element;
        size++;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 10:17
     * @Description Delete a element from array.
     * @Param index The position(starts with 1) that needs to be deleted.
     * @Return
     **/
    public int deleteArray(int index)throws Exception{
        //从位置“1”(也就是Java数组下标的0位置)开始删除
        if(index < 1 || index > (size+1)){
            throw new IndexOutOfBoundsException("数组越界！！");
        }
        int deleteElement = array[index-1];
        for(int i = index - 1;i < size-1;i++){
            array[i] = array[i+1];
        }
        size--;
        return deleteElement;
    }

    public void output(){
        System.out.println("Array size = "+size+";");
        System.out.print("Array:[");
        for(int i = 0;i < size;i++){
            System.out.print(array[i]);
            if(i != (size-1)){
                System.out.print(", ");
            }
        }
        System.out.println("].");
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 9:58
     * @Description Expand the array.
     * @Return void
     **/
    public void arrayExpansion(){
        int []newArray = new int[array.length*2];//数组扩容
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 10:05
     * @Description Insert a data into array,position starts with 0.
     * @Param index The position in array(starts with 0).
     * @Param element The data(should be the type of int) which needs to be inserted.
     * @Return void
     **/
    public void insertArrayFromZero(int index,int element)throws Exception{
        //从数组的位置0插入数据，并且数组是顺序存储
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界！！");
        }
        if(size >= array.length){
            arrayExpansion();
        }
        for(int i = size - 1;i >= index;i--){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 10:17
     * @Description Delete a element from array.
     * @Param index The position(starts with 0) that needs to be deleted.
     * @Return int The deleted element.
     **/
    public int deleteArrayFromZero(int index)throws Exception{
        //数组位置以0开始
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组越界！！");
        }
        int deleteElement = array[index];
        for(int i = index;i < size - 1;i++){
            array[i] = array[i+1];
        }
        size--;
        return deleteElement;
    }
}
