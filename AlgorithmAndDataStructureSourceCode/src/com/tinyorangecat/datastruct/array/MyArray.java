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
     * @Param index The position in array.
     * @Param element The data(should be the type of int) which needs to be inserted.
     * @Return null
     **/
    public void insertArray(int index,int element)throws Exception{
        //从数组的位置“1”开始（也就是从Java数组下标为0的位置）插入数据，并且数组是顺序存储
        if(index < 1 || index > (size+1)){
            throw new ArrayIndexOutOfBoundsException("数组越界！");
        }
        //从后往前，将数据后移一位，为需要插入的数据空出位置
        for(int i = size-1;i >= index-1;i--){
            array[i+1] = array[i];
        }
        array[index-1] = element;
        size++;
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
        System.out.print("].");
    }
}
