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

栈是一种线性的数据结构，栈中的元素是**先入后出**。最先入栈的元素存放位置叫做**栈底**，最后入栈的元素的存放位置叫做**栈顶**。

#### (1).栈的基本操作

* 出栈[^StackInOutTN]
* 入栈[^StackInOutTN]

[^StackInOutTN]: T(n) = O(1)

### 5.队列

队列中的元素只能**先入先出**。

#### (1).队列的基本操作

* 入队[^QueueInOutTN] 队列的出口是**队头**

* 出队[^QueueInOutTN] 队列的入口是**队尾**

队列队尾指针指向位置永远**空出一位**，队列最大容量比数组长度小一位。

**循环队列**可以解决不断的出队、入队导致的空间容量不够的问题。

循环队列是指在队列容量已满[^FullQueue]时，将队尾指针重新移到队列头部。

```java
	//循环队列的实现
	private int []array;
    private int front;
    private int rear;

    public MyQueue(int capacity){
        array = new int[capacity];
    }

    public void enterQueue(int element)throws Exception{
        //a%b = a-(a/b)*b
        if((rear+1)%array.length == front){
            throw new IndexOutOfBoundsException("队列已满！！");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int outQueue()throws Exception{
        if(rear == front){
            throw new IndexOutOfBoundsException("空队列！！");
        }
        int deletedData = array[front];
        front = (front + 1) % array.length;
        return deletedData;
    }

    public void output(){
        System.out.println("Queue size = "+array.length+";");
        System.out.print("Queue:[");
        for(int i = front; i != rear; i=(i+1)%array.length){
            System.out.print(array[i]);
            if((i+1)%array.length != rear){
                System.out.print(", ");
            }
        }
        System.out.println("].");
    }
```

[^QueueInOutTN]: T(n) = O(1)
[^FullQueue]: (队尾下标+1) % 数组长度 = 队头下标

**取余运算**：a%b = a-(a/b)*b

**优先队列**按照数据的优先级来决定谁先出队，优先队列基于**二叉堆**来实现。

### 6.散列表

散列表也叫**哈希表**，以**键**、**值**的映射关系[^JavaKeyValue]来存储数据。

哈希表将键值经过**哈希函数**的运算取得数组中的下标位置。

Java HashMap的哈希函数是：index = HashCode(key)[^HashcodeInfo] % ArrayLength

[^JavaKeyValue]: JDK中将Key-Value键值对叫做**Entry**。
[^HashcodeInfo]: Java中所有的对象都有一个hashcode，且都是整型数据。

#### (1).散列表的写操作

通过哈希函数将key转化为下标，如果下标位置没有存数据，将数据Entry存在对应下标位置。

**哈希冲突**：列表的大小是固定的，可能会出现不同的Key，但是通过哈希函数得到了相同的下标。

解决哈希冲突：

* 1).开放寻址法：若当前下标已有数据，则查看下一下标是否为空，若下一下标为空，则存储在此下标，若不为空，则继续查找下下一下标。
* 2).链表法：HashMap中，每一个Entry不仅是一组数据，更是一个链表的头节点，每一个Entry通过next指针指向下一个Entry；当新的Entry在映射存储位置发生冲突时，可将新的Entry插入链表即可。

#### (2).散列表的读操作

通过哈希函数将key转化为下标，对比链表的头节点位置上的Entry的key是否一致，若不一致，则遍历链表的下一节点，若key一致，则返回value。

#### (3).散列表的扩容

散列表扩容的必要性：数据的增多会使哈希冲突发生的概率提高，导致相同的下标下存储着大量的元素，形成长链表，影响散列表的插入、读取性能。

HashMap的扩容[^HashExpansionCondition]：

* 1).扩容：新建一个数组，长度为原来的2倍。
* 2).**重新Hash**：因为数组长度有变，所以Hash规则也随之改变，需要遍历原数组的Entry，重新使用哈希函数将Entry存放在新的数组中。



[^HashExpansionCondition]: HashMap的扩容条件是：HashMap.size >=  Capacity(HashMap的当前长度) * LoadFactor(HashMap负载因子：默认为0.75f)



## 三、树