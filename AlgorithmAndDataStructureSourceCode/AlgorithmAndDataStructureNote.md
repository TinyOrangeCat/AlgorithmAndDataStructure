# 基础算法与数据结构

 

## 一、算法概述

### 1.时间复杂度和空间复杂度

衡量算法好坏的标准是**时间复杂度**和**空间复杂度**。

时间复杂度：算法运行的时间的度量T(n)。

空间复杂度：算法在运行中临时占用存储空间大小的度量S(n)。

### 2.数据结构

数据结构是计算机组织、管理和存储数据的方式。

#### (1).线性结构

常见的线性结构有：数组、链表，及其衍生出来的栈、队列。

#### (2).树

如二叉树，二叉堆。

#### (3).图

#### (4).其他

如跳表、哈希链表。



## 二、数据结构基础

实际存在的数据结构被称为**“物理结构”**，物理结构分为**顺序存储结构**（数组）和**链式存储结构**（链表）；

依赖于物理结构而存在的另一种较抽象的数据结构被称为**“逻辑结构”**，逻辑结构分为**“线性结构”**（栈、队列、顺序表）和**“非线性结构”**（树、图）。

### 1.数组

有限个相同类型变量组成的有序集合被称为数组。

数据是顺序存储，因此数组可以实现顺序表。

(1).读取元素/更新元素[^ReadArrayTN]



数组通过下标读取元素，这种方式被称为**随机读取**。

(2).插入元素

​	1).尾部插入

​	2).中间插入

​	3).超范围插入（需要数组扩容）

 ````java

	private int []array;
    private int size;

    public MyArray(int capacity){
        this.array = new int[capacity];
        this.size = 0;
    }

    public void insertArray(int index,int element)throws Exception{
        //从数组的位置“1”开始（也就是从Java数组下标为0的位置）插入数据，并且数组是顺序存储
        if(index < 1 || index > (size+1)){
            throw new ArrayIndexOutOfBoundsException("数组越界！");
        }
        //从后往前，将数据后移一位
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
 ````



[^ReadArrayTN]: T(n) = O(1)

### 2.链表

### 3.栈

### 4.队列

### 5.散列表





