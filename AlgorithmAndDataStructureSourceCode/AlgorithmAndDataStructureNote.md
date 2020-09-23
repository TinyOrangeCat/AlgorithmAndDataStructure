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

数据是**顺序存储**，因此数组可以实现顺序表。

#### (1).读取元素/更新元素[^ReadArrayTN]

数组通过下标读取元素，这种方式被称为**随机读取**。

#### (2).插入元素[^InsertArrayTN]

* 尾部插入

* 中间插入

* 超范围插入（需要数组扩容）

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
	public void arrayExpansion(){
        int []newArray = new int[array.length*2];//数组扩容
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
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
 ````

[^ReadArrayTN]: T(n) = O(1)
[^InsertArrayTn]: T(n) = O(n)

(3).删除元素[^DeleteArrayTn]

```java
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
```

[^DeleteArrayTn]: T(n) = O(n)

### 2.链表

链表在内存中是以**随机存储**的方式进行存储的，是一种**非连续**、**非顺序**的数据结构。

链表的结构是：

数据+下一个节点 ----> 数据+下一节点 ----> 数据+下一节点 ----> null

头节点                                                                 尾节点

#### (1).查找节点[^FindChainTN]

#### (2).更新节点

#### (3).插入节点[^InsertChainTN]

* 尾部插入
* 中间插入
* 头部插入

#### (4).删除节点[^DeleteChainTN]

* 尾部删除
* 中间删除
* 头部删除

```java
	public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    private Node head;
    private Node lastNode;
    private int size;

    public void insertChain(int data,int index)throws Exception{
        //从链表的位置0处开始插入数据
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围！！");
        }
        Node insertedNode = new Node(data);
        if(size == 0){//空链表，头节点等于尾节点
            head = insertedNode;
            lastNode = insertedNode;
        }else if(index == 0){//头部插入节点
            insertedNode.next = head;
            head = insertedNode;
        }else if(index == size){//尾部插入节点，将要插入的位置等于链表目前容量大小
            lastNode.next = insertedNode;
            lastNode = insertedNode;
        }else{//中间插入节点
            Node preNode = getChain(index-1);
            insertedNode.next = preNode.next;
            preNode.next = insertedNode;
        }
        size++;
    }

    public Node deleteChain(int index)throws Exception{
        //链表从位置0开始存储数据
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node deletedNode;
        if(index == 0){//头节点
            deletedNode = head;
            head = head.next;
        }else if(index == (size-1)){//尾节点
            Node preNode = getChain(index-1);
            deletedNode = preNode.next;
            preNode.next = null;
            lastNode = preNode;
        }else{//中间节点
            Node preNode = getChain(index-1);
            deletedNode = preNode.next;
            preNode.next = preNode.next.next;
//          Node nextNode = preNode.next.next;
//          preNode.next = nextNode;
        }
        size--;
        return deletedNode;
    }

    public Node getChain(int index)throws Exception{
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        Node tempt = head;
        for(int i = 0;i < index;i++){
            tempt = tempt.next;
        }
        return tempt;
    }

    public void output(){
        System.out.println("Node size : "+size+";");
        Node tempt = head;
        int count = 0;
        System.out.print("Node is : [");
        while (tempt != null){
            count++;
            System.out.print(tempt.data);
            if(count != size){
                System.out.print(", ");
            }
            tempt = tempt.next;
        }
        System.out.println("].");
    }
```

[^FindChainTN]: T(n) = O(n)
[^InsertChainTN]:  T(n) = O(1)
[^DeleteChainTN]:  T(n) = O(1)

### 3.数组和链表的对比

时间复杂度对比

|      | 插入数据 | 更新数据 | 删除数据 | 查找数据 |
| :----: | :--------: | :--------: | :--------: | :--------: |
| 数组 | T(n) = O(n) | T(n) = O(1) | T(n) = O(n) | T(n) = O(1) |
| 链表 | T(n) = O(1) | T(n) = O(1) | T(n) = O(1) | T(n) = O(n) |

* 数组更适合读操作多，写操作少的场合；而链表更适合进行插入、删除操作，由其是在尾部频繁插入、删除数据时。

### 4.栈

### 5.队列

### 6.散列表





