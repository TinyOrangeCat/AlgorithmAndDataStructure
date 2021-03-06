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
        if(index < 0 || index >= size){
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

### 1.树

**树**是n(n>=0)个节点的有限集。当n=0时，称为空树。一个非空树有如下特点：

* (1).有且仅有一个特定的根的节点；
* (2).当n>1时，其余节点可以分为m(m>0)个不相交的有限集合，每一个集合本身又是树，称为根的**子树**。

树末端的节点被称为**叶子节点**；树的最大层数被称为树的**高度**、**深度**。

### 2.二叉树

#### (1).什么是二叉树

二叉树的每个节点最多有两个孩子节点。

二叉树可以采用**链式存储结构**、**数组**的方式进行存储（但比较浪费空间）。

二叉树的应用：主要应用与**查找操作和维持相对顺序**。

#### (2).满二叉树与完全二叉树

**满二叉树**：一个二叉树的非叶子节点均有左右孩子，并且所有的叶子节点均在同一层级。

**完全二叉树**：对于一个有n个节点的二叉树，按层级顺序编号，则所有层级编号为从1到n。如果二叉树的所有节点编号和同样深度的满二叉树的编号从1到n位置相同，则称为完全二叉树。

#### (3).二叉树的应用

二叉树的应用：主要应用与**查找操作和维持相对顺序**。

* 二叉查找树[^BinaryTreeFindTN]：如果左子树不为空，则左子树上所有节点的值均小于根节点的值；如果右子树不为空，则右子树上所有节点的值均大于根节点的值；左右子树都是二叉查找树。
* 维持相对顺序：如二叉查找树，要维持新插入数据不影响二叉树的结构，需要二叉树的**自平衡**（如红黑树、AVL树、树堆等）。



[^BinaryTreeFindTN]: T(n) = O(logn)

#### (4).二叉树的遍历

从节点之间的位置关系来分，二叉树的遍历可分为：

##### 1).前序遍历

根 ——> 左  ——> 右

##### 2).中序遍历

左 ——> 根  ——> 右

##### 3).后序遍历

左 ——> 右  ——> 根

##### 4).层序遍历

从宏观角度来看，二叉树的遍历可分为：

##### 1).深度优先遍历

前序遍历、中序遍历、中序遍历。

##### 2).广度优先遍历

层序遍历。

```java
	public static class BinaryTreeNode{
        int data;
        private BinaryTreeNode leftNode;
        private BinaryTreeNode rightNode;

        BinaryTreeNode(int data){
            this.data = data;
        }
    }

    public BinaryTreeNode createBinaryTree(LinkedList<Integer> binaryTreeArray){
        BinaryTreeNode tree = null;
        if(binaryTreeArray == null || binaryTreeArray.isEmpty()){
            return null;
        }
        Integer data = binaryTreeArray.removeFirst();
        if(data != null){
            tree = new BinaryTreeNode(data);
            tree.leftNode = createBinaryTree(binaryTreeArray);
            tree.rightNode = createBinaryTree(binaryTreeArray);
        }
        return tree;
    }

    public void preOrderTraversal(BinaryTreeNode tree){//前序遍历
        if(tree == null){
            return;
        }
        System.out.print(tree.data+" ");
        preOrderTraversal(tree.leftNode);
        preOrderTraversal(tree.rightNode);
    }

    public void preOrderTraversalByStack(BinaryTreeNode tree){//前序遍历
        if(tree == null){
            return;
        }
        Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();

        while (tree != null || !nodeStack.isEmpty()){
            while (tree != null){
                System.out.print(tree.data+" ");
                nodeStack.push(tree);
                tree = tree.leftNode;
            }
            if(!nodeStack.isEmpty()){
                tree = nodeStack.pop();
                tree = tree.rightNode;
            }
        }

    }

    public void midOrderTraversal(BinaryTreeNode tree){//中序遍历
        if(tree == null){
            return;
        }
        midOrderTraversal(tree.leftNode);
        System.out.print(tree.data+" ");
        midOrderTraversal(tree.rightNode);
    }

    public void midOrderTraversalByStack(BinaryTreeNode tree){//中序遍历
        if(tree == null){
            return;
        }
        Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();

        while (tree != null || !nodeStack.isEmpty()){
            while (tree != null){
                nodeStack.push(tree);
                tree = tree.leftNode;
            }
            if(!nodeStack.isEmpty()){
                tree = nodeStack.pop();
                System.out.print(tree.data+" ");
                tree = tree.rightNode;
            }
        }

    }

    public void postOrderTraversal(BinaryTreeNode tree){//后序遍历
        if(tree == null){
            return;
        }
        postOrderTraversal(tree.leftNode);
        postOrderTraversal(tree.rightNode);
        System.out.print(tree.data+" ");
    }

    public void postOrderTraversalByStack(BinaryTreeNode tree){//后序遍历，未完待续。。。
        if(tree == null){
            return;
        }
        Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();

        while (tree != null || !nodeStack.isEmpty()){
            
        }
    }

    public void levelOrderTraversal(BinaryTreeNode tree){//层序遍历
        if(tree == null){
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(tree);
        while (!queue.isEmpty()){
            BinaryTreeNode binaryTreeNode = queue.poll();
            System.out.print(binaryTreeNode.data+" ");
            if(binaryTreeNode.leftNode != null){
                queue.offer(binaryTreeNode.leftNode);
            }
            if(binaryTreeNode.rightNode != null){
                queue.offer(binaryTreeNode.rightNode);
            }
        }

    }
```



### 3.二叉堆

二叉堆本质上是一种**完全二叉树**。

#### (1).二叉堆的分类

* 最大堆：最大堆任一父节点的值都要大于或等于左、右孩子节点的值。
* 最小堆：最小堆任一父节点的值都要小于或等于左、右孩子节点的值。

二叉堆的根节点是**堆顶**。

#### (2).二叉堆的自我调整

##### 1).插入节点[^InsertDeleteBinaryHeap]

二叉堆将新节点插入完全二叉树的最后位置，然后将节点的值与所在子树的根节点进行比较，若不符合最大堆、最小堆的性质，则对该节点进行“上浮”操作。

##### 2).删除节点[^InsertDeleteBinaryHeap]

二叉堆删除的是堆顶，原来的堆顶被删除后，会将堆的最后一个节点补到堆顶，然后将新的堆顶与左、右孩子节点进行比较，若不符合最大堆、最小堆的性质，则对该节点进行“下沉”操作。

##### 3).构建二叉堆[^BuildBinaryHeap]

构建二叉堆就是把一个无序的二叉树构建为二叉堆，即**让所有非叶子节点依次下沉**。从完全二叉树的最后一个节点开始进行“上浮”、“下沉”调整。

```java
	//以下均是构建最小堆
	public static void buildBinaryHeap(int []array){
        for(int i = (array.length-2)/2;i >= 0;i--){//从最后一个非叶子节点开始下沉
            goDown(array,i,array.length);
        }
    }

    public static void floatUpward(int []array){
        int childIndex = array.length - 1;
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex-1)/2;
        }
        array[childIndex] = temp;
    }

    public static void goDown(int []array,int parentIndex,int length){
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < length){
            if(childIndex+1 < length && array[childIndex+1] < array[childIndex]){//右孩子应小于左孩子
                childIndex++;
            }
            if(temp <= array[childIndex]){//最小堆，父节点小于左、右孩子
                break;
            }
            array[parentIndex] = array[childIndex];//较小数上浮到父节点
            parentIndex = childIndex;
            childIndex = parentIndex*2 + 1;
        }
        array[parentIndex] = temp;
    }
```



[^InsertDeleteBinaryHeap]: T(n) = O(logn)
[^BuildBinaryHeap]: T(n) = O(n)



### 4.优先队列

#### (1).优先队列的特点

* **最大优先队列**：无论入队顺序如何，最先出队的永远是队列中最大的元素。
* **最小优先队列**：无论入队顺序如何，最先出队的永远是队列中最大的元素。



#### (2).优先队列的实现

优先队列基于**二叉堆**实现。

##### 1).入队[^InOutFirstQueue]

将值插入堆的末尾叶子节点，进行上浮操作。

##### 2),出队[^InOutFirstQueue]

堆顶出队，末尾叶子节点顶替原先堆顶，进行下沉操作。

```java
	//构建最小优先队列
    private int []queueArray;
    private int size;

    public PriorityQueue(int capacity){
        this.queueArray = new int[capacity];
    }

    public void enQueue(int data){
        if(size >= queueArray.length){
            expansion();
        }
        queueArray[size++]=data;
        floatUpward();
    }

    private void expansion(){
        int newSize = this.size*2;
        this.queueArray = Arrays.copyOf(this.queueArray,newSize);
    }

    private void floatUpward(){
        int childIndex = size - 1;
        int parentIndex = (childIndex-1)/2;
        int temp = queueArray[childIndex];
        while (childIndex > 0 && temp < queueArray[parentIndex]){
            queueArray[childIndex] = queueArray[parentIndex];
            childIndex = parentIndex;
            parentIndex = childIndex/2;//这里除2即可
        }
        queueArray[childIndex] = temp;
    }

    public int deQueue()throws Exception{
        if(size <= 0){
            throw new IndexOutOfBoundsException("队列为空！！");
        }
        int head = queueArray[0];
        queueArray[0] = queueArray[--size];//--size,先减再赋值
        goDown();
        return head;
    }

    private void goDown(){
        int parentIndex = 0;//整个队列需要下沉
        int childIndex = 1;//层序遍历
        int temp = queueArray[parentIndex];
        while (childIndex < size){
            if(childIndex+1 < size && queueArray[childIndex+1] < queueArray[childIndex]){
                childIndex++;
            }
            if(temp <= queueArray[childIndex]){
                break;
            }
            queueArray[parentIndex] = queueArray[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 + 1;
        }
        queueArray[parentIndex] = temp;
    }

    public void output(){
        System.out.println("Priority queue size: "+size);
        System.out.print("Priority queue is:[");
        for (int i = 0;i < size;i++){
            System.out.print(queueArray[i]);
            if(i < size-1){
                System.out.print(", ");
            }
        }
        System.out.println("].");
        System.out.println(Arrays.toString(queueArray));
    }
```



[^InOutFirstQueue]: T(n) = O(logn)



## 四、排序算法

排序算法按稳定性可分为**稳定排序**（值相同的元素排序前后顺序不变）和**不稳定排序**（值相同的元素排序前后顺序被打乱）。

### 1.引言

#### (1).时间复杂度为O(n<sup>2</sup>)的排序算法

* **冒泡排序**
* **选择排序**
* **插入排序**
* **希尔排序**



#### (2).时间复杂度为O(nlogn)的排序算法

* **快速排序**
* **归并排序**
* **堆排序**



#### (3).时间复杂度为线性的排序算法

* **计数排序**
* **桶排序**
* **基数排序**



### 2.冒泡排序

冒泡排序是一种**稳定排序**。

左-->右比较排序。

```java
public class BubbleSort {
    public static void sort(int []array){
        //从小到大进行冒泡排序
        int lastExchangeIndex = 0;//记录上次交换位置
        int sortBorder = array.length - 1;//进行排序的边界
        for(int i = 0;i < array.length;i++){
            boolean isSorted = true;
            for(int j = 0;j < sortBorder;j++){//冒泡排序已排序过的位置，不需要再进行排序
                if(array[j] > array[j+1]){//前一个数大于后一个数，进行数据交换
                    int tempt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempt;
                    isSorted = false;//记录此次排序是无序的
                    lastExchangeIndex = j;//记录最后交换数据的位置
                }
            }
            sortBorder = lastExchangeIndex;
            if(isSorted){//若上次已是有序状态、没有进行数据换位，则无需进行后续排序
                break;
            }
        }
    }
}
```



### 3.鸡尾酒排序

左-->右，右-->左。

```java
public class CocktailSort {

    public static void sort(int []array){
        //因为是鸡尾酒排序，从左到右，从右到左进行比对，已经对比好的首尾位置不用进行第二次对比，故最终需要比对的次数就就是数组总长的一半
        for (int i = 0;i < array.length/2;i++){
            boolean isSorted = true;
            //左到右
            for(int j = i;j < array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    int tempt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempt;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
            isSorted = true;
            //右到左
            for(int j = array.length-i-1;j > i;j--){
                if(array[j] < array[j-1]){
                    int tempt = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tempt;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }

    }
}
```



### 4.快速排序

冒泡排序和快速排序都是**交换排序**。、

快速排序采用**分治法**进行排序，每一轮中挑选一个基准元素，比基准元素大的元素被分到一边，比基准元素小的元素被分到另一边。

#### (1).基准元素的选择

随机选择一个基准元素，将基准元素和头元素交换位置。

#### (2).元素的交换

* 双边循环法

选定基准元素，数组两端定义左、右指针，先对比右指针，若右指针数小于基准数，则右指针停止，开始对比左指针数，若左指针数大于

基准元素，左指针停止，左右指针对比，右小于左，则交换元素，右指针向左移动，继续比较，最后左右指针重合，基准元素与重合元素交换。

* 单边循环法

选定基准元素，数组首端定义mark指针，向后遍历元素，如果有元素小于基准元素，mark指针右移，mark指针位置和对比位置交换。

```java
	public static void doubleCirculationSort(int []array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = doublePartition(array,startIndex,endIndex);
        doubleCirculationSort(array,startIndex,pivotIndex - 1);
        doubleCirculationSort(array,pivotIndex + 1,endIndex);
    }

    private static int doublePartition(int []array,int startIndex,int endIndex){
        //双边循环法
        int pivot = array[startIndex];//选取头元素作为基准数
        int leftPointer = startIndex;
        int rightPinter = endIndex;
        while (leftPointer != rightPinter){//左、右指针不重合，数组未遍历完毕
            while (leftPointer < rightPinter && array[rightPinter]>pivot){//先操作右指针左移
                rightPinter--;
            }
            while (leftPointer < rightPinter && array[leftPointer] <= pivot){//操作左指针右移
                leftPointer++;
            }
            if(leftPointer < rightPinter){
                int temp = array[rightPinter];
                array[rightPinter] = array[leftPointer];
                array[leftPointer] = temp;
            }
        }
        //左、右指针重合，交换指针位置元素与头元素
        array[startIndex] = array[leftPointer];
        array[leftPointer] = pivot;
        return leftPointer;
    }

    public static void unilateralCirculationSort(int []array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = unilateralPartition(array,startIndex,endIndex);
        unilateralCirculationSort(array,startIndex,pivotIndex-1);
        unilateralCirculationSort(array,pivotIndex+1,endIndex);
    }

    private static int unilateralPartition(int []array,int startIndex,int endIndex){
        //单边循环法
        int pivot = array[startIndex];
        int mark = startIndex;
        for(int i = startIndex+1;i <= endIndex;i++){
            if(array[i] < pivot){
                mark++;//指针右移
                //指针位置与对比位置交换
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }
        }
        //数组遍历一轮结束，指针位置数据与基准数交换
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void unilateralCirculationSortByStack(int []array,int startIndex,int endIndex){
        //使用非递归的方式实现单边循环快速查找
        Stack<Map<String,Integer>> quickSortStack = new Stack<Map<String,Integer>>();
        Map<String,Integer> indexMap = new HashMap<String,Integer>();
        indexMap.put("startIndex",startIndex);
        indexMap.put("endIndex",endIndex);
        quickSortStack.push(indexMap);
        while (!quickSortStack.isEmpty()){
            Map<String,Integer> paramMap = quickSortStack.pop();
            int pivotIndex = unilateralPartition(array,paramMap.get("startIndex"),paramMap.get("endIndex"));
            if(paramMap.get("startIndex") < pivotIndex - 1){
                Map<String,Integer> leftParam = new HashMap<String,Integer>();
                leftParam.put("startIndex",paramMap.get("startIndex"));
                leftParam.put("endIndex",pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if(paramMap.get("endIndex") > pivotIndex + 1){
                Map<String,Integer> rightParam = new HashMap<String,Integer>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",paramMap.get("endIndex"));
                quickSortStack.push(rightParam);
            }
        }
    }
```

### 5.堆排序

从大到小，构建最小堆；从小到大，构建最大堆。

```java
public class HeapSort {

    public static void sort(int []array){
        //从大到小进行堆排序
        for(int i = (array.length - 2)/2;i >= 0;i--){
            goDown(array,i,array.length);//建最小堆
        }
        //堆顶最小的数置于数组末尾，并重新建最小堆
        for(int i = array.length - 1;i > 0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            goDown(array,0,i);
        }

    }

    private static void goDown(int []array,int parentIndex,int length){
        int childIndex = parentIndex*2+1;
        int temp = array[parentIndex];
        while(childIndex < length){
            if(childIndex+1 < length && array[childIndex+1] < array[childIndex]){
                childIndex++;
            }
            if(temp <= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = temp;
    }
}

```



### 6.计数排序

```java
	public static void sort(int []array){
        //从大到小进行堆排序
        //得到最大元素
        int biggest = array[0];
        for(int i = 0;i < array.length;i++){
            if(array[i]>biggest){
                biggest = array[i];
            }
        }
        int []countArray = new int[biggest+1];//计数数组
        for(int i = 0;i < array.length;i++){
            countArray[array[i]]++;
        }
        //遍历计数数组，将不为0的计数数组下标转存到结果数组
        int index = 0;
        for(int i = countArray.length-1;i >= 0;i--){
            for(int j = 0;j < countArray[i];j++){
                array[index++] = i;
            }
        }
    }
```



前一个计数排序比较占用内存，而且在遇到相同的元素时，会打乱相同元素的顺序，下面改进后的计数排序是**顺序排序**且占用内存较小。

选出最大、最小数（偏移量min），创建计数数组（最大数-最小数+1=计数数组长度），数组a中每一个数减去偏移量得到计数数组下标i，计数数组c对应下标位置j的数加1，数组遍历完成后，计数数组从下标1开始与上一下标位置上的数相加，并将结果重新赋值进对应计数数组下标位置。最后再次遍历数组（c[j] = c[j] + c[j-1]），值a[i]减去偏移量（min）得到index，计数数组中对应index的数值就代表数组a[i]的排序位置（排序位置 = c[a[i] - min]），最后将刚刚访问的计数数组对应下标的值减1。

```java
	public static int[] improveSort(int []array){
        //从小到大排序
        int biggest = array[0];
        int smallest = array[0];//偏移量
        for(int i = 0;i < array.length;i++){
            if(array[i]>biggest){
                biggest = array[i];
            }
            if(array[i] < smallest){
                smallest = array[i];
            }
        }
        int []countArray = new int[biggest-smallest+1];
        for(int i = 0;i < array.length;i++){
            countArray[(array[i]-smallest)]++;
        }
        //从数组1下标开始，计数数组值两两相加
        for(int i = 1;i < countArray.length;i++){
            countArray[i] = countArray[i]+countArray[i-1];
        }
        int []resultArray = new int[array.length];
        //countArray中的数就是对应array中每个数的排序次序
        for(int i = 0;i < array.length;i++){
            resultArray[countArray[array[i]-smallest]-1] = array[i];
            countArray[array[i]-smallest]--;//countArray对应位置下存的一组数少一个
        }
        return resultArray;
    }
```



### 7.桶排序

计数排序只能针对整数进行排序；而且当数组数值相差较大时，计数排序并不适合。

**桶的区间跨度 = （最大值 - 最小值）/（桶的数量 - 1）**

```java
public class BucketSort {

    public static void sort(double []array){
        //从小到大进行桶排序
        double biggest = array[0];
        double smallest = array[0];
        for(int i = 0;i <array.length;i++){
            if(array[i] > biggest){
                biggest = array[i];
            }
            if(array[i]< smallest){
                smallest = array[i];
            }
        }
        double d = biggest - smallest;
        int bucketNum = array.length;
        //创建桶
        ArrayList<LinkedList<Double>> buckets = new ArrayList<LinkedList<Double>>(bucketNum);
        for(int i = 0;i < bucketNum;i++){
            buckets.add(new LinkedList<Double>());
        }
        //在桶中装入数据
        for(int i = 0;i < array.length;i++){
            int num = (int)((array[i]-smallest)*(bucketNum-1)/d);
            buckets.get(num).add(array[i]);
        }
        //对桶中数据进行排序
        for(int i = 0;i < buckets.size();i++){
            Collections.sort(buckets.get(i));
        }
        //输出桶中数据
        int index = 0;
        for(LinkedList<Double> bucket : buckets){
            for(Double data : bucket){
                array[index++] = data;
            }
        }
    }
}
```



### 8.小结

| 排序 | 平均时间复杂度 | 最坏时间复杂度 | 空间复杂度 | 是否稳定排序 |
| :----: | :--------------: | :--------------: | :----------: | :------------: |
| 冒泡排序 | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1) | 稳定 |
| 鸡尾酒排序 | O(n<sup>2</sup>) | O(n<sup>2</sup>) | O(1) | 稳定 |
| 快速排序 | O(nlogn) | O(n<sup>2</sup>) | O(logn) | 不稳定 |
| 堆排序 | O(nlogn) | O(nlogn) | O(1) | 不稳定 |
| 计数排序 | O(n+m) | O(n+m) | O(m) | 稳定 |
| 桶排序 | O(n) | O(nlogn) | O(n) | 稳定 |



## 五、面试中的算法

### 1.如何判断一个链表有环

有一个单身链表，如何判断链表中是否出现了环？

​                        1 &larr; 8

​						&darr;		&uarr;

5 &rarr; 3 &rarr; 7 &rarr; 2 &rarr; 6

解法：创建两个指针，P1、P2，P1每次操作向前移1位，P2每次操作向前移2位，若干次操作后，若P1指针与P2指针重合，则说明链表有环。

```java
public class CycleChain {
    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
        }

        @Override
        public String toString(){
            return String.valueOf(data);
        }
    }

    public static boolean hasCycleChain(Node chain){
        if(chain == null){
            return false;
        }
        Node pointerOne = chain;
        Node pointerTwo = chain;
        while (pointerOne != null && pointerTwo != null){
            pointerOne = pointerOne.next;
            pointerTwo = pointerTwo.next.next;
            if(pointerOne == pointerTwo){
                return true;
            }
        }
        return false;
    }
```

时间复杂度：**T(n) = O(n)**

空间复杂度：**S(n) = O(1)**

扩展问题：

* 如果链表有环，如何求出环的长度？

P2每次比P1多走一步，在P1、P2第一次相遇时，两指针继续前进，记录前进次数直到P1、P2再次相遇，此时P2比P1多走整整一圈。

环长 = 速差 * 前进次数

* 如果链表有环，如何求出入环节点？

首次相遇后，将其中一个指针放到起点，然后两指针同时每次前进一步，再次相遇的位置就是入环节点。

### 2.最小栈的实现

实现一个栈，有出栈（pop），入栈（push），取最小元素（getMin），且时间复杂都是O(1)。

注：取最小值只是需要知道当前栈内的最小元素是什么，不是说最小元素需要出栈。

解法：

新建两个栈（mainStack，minStack），每次入栈先进mainStack，再将值与minStack栈顶进行比较，如果值小于minStack栈，则该值也进入minStack。

```java
public class MinimumStack {
    static Stack<Integer> mainStack = new Stack<Integer>();//主栈
    static Stack<Integer> minStack = new Stack<Integer>();//最小栈

    public void push(int data){
        mainStack.push(data);//所有元素均进主栈
        //若最小栈顶元素大于当前元素，则该元素也应该进最小栈
        if(minStack.isEmpty() || minStack.peek() > data){
            minStack.push(data);
        }
    }

    public Integer pop(){
        //主栈栈顶元素与最小栈栈顶元素相同，则最小栈也应出栈
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public Integer getMin() throws Exception{
        if(minStack.isEmpty()){
            throw new IndexOutOfBoundsException("最小栈为空！");
        }
        return minStack.peek();
    }

}
```



### 3.如何求出最大公约数

求出两个数的最大公约数。

```java
public class GreatestCommonDivision {

    public static int getGreatestCommonDivision1(int a,int b){
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big % small == 0){
            return small;
        }
        for(int i = small/2;i > 1;i--){
            if(big % i == 0 && small % i ==0){
                return i;
            }
        }
        return 1;
    }

    public static int getGreatestCommonDivision2(int a,int b){
        //辗转相除法（欧几里德法，整数a和b(a>b)的最大公约数等于，a和b的相除的余数c和最小数b的最大公约数）
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big % small == 0){
            return small;
        }
        return getGreatestCommonDivision2(big % small,small);
    }

    public static int getGreatestCommonDivision3(int a,int b){
        //更相减损术（整数a和b(a>b)的最大公约数等于，a和b的差值c和最小数b的最大公约数）
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big == small){
            return big;
        }
        return getGreatestCommonDivision3(big-small,small);
    }

    public static int getGreatestCommonDivision4(int a,int b){
        //辗转相除法+更相减损术
        //&运算：同1则1，否则为0
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big == small){
            return big;
        }
        if((big & 1) == 0 && (small&1) == 0){
            return getGreatestCommonDivision4(big>>1,small >>1)<<1;
        }else if((big & 1) == 0 && (small&1) != 0){
            return getGreatestCommonDivision4(big>>1,small);
        }else if((big & 1) != 0 && (small&1) == 0){
            return getGreatestCommonDivision4(big,small>>1);
        }else{
            return getGreatestCommonDivision4(big-small,small);
        }
    }
}
```

### 4.2的整数次幂

如何判断一个数是否为2的整数次幂？

```java
public class PowerOf2 {

    public static boolean isPowerOf2V1(int num){
        //T(n) = O(logn)
        int temp = 1;
        while(temp <= num){
            if (temp == num){
                return true;
            }
            temp *= 2;
        }
        return false;
    }

    public static boolean isPowerOf2V2(int num){
        //T(n) = O(logn)
        int temp = 1;
        while(temp <= num){
            if (temp == num){
                return true;
            }
            temp <<= 1;
        }
        return false;
    }

    public static boolean isPowerOf2V3(int num){
        //T(n) = O(1)
        //所有2的整数次幂的二进制最高位为1，其他位均为0，且其二进制数减1后所有位均为1。
        return (num&num-1)==0;
    }
}
```



### 3.无序数组排序后的最大相邻差

有一个无序整型数组，如何求出该数组排序后的任意两个相邻元素的最大差值？

无序数组：2 6 3 9 5 10 9

排序结果：2 3 4 5 6  9 10

​                                 &darr;   &darr;

​                            最大差值：3

解法：桶排序，桶的最大值和右侧最小值的最大差值既是结果。

```java
public class GetTheBiggestDifference {
    private static class Bucket{
        Integer max;
        Integer min;
    }

    public static int getTheTheBiggestSortedDifference(int []array){
        if(array == null){
            return 0;
        }
        int max = array[0];
        int min = array[0];
        for(int i = 0;i < array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        int d = max - min;
        if(d == 0){
            return 0;
        }
        int bucketNum = array.length;
        Bucket []buckets = new Bucket[bucketNum];
        for(int i = 0;i < bucketNum;i++){
            buckets[i] = new Bucket();
        }
        for(int i = 0;i < array.length;i++){
            int index = ((array[i] - min)*(bucketNum - 1)/d);
            if(buckets[index].min == null || buckets[index].min > array[i]){
                buckets[index].min = array[i];
            }
            if(buckets[index].max == null || buckets[index].max < array[i]){
                buckets[index].max = array[i];
            }
        }

        //左桶最大值减去右桶最小值
        int leftMax = buckets[0].max;
        int maxDifference = 0;
        for(int i = 1;i < buckets.length;i++){
            if(buckets[i].min == null){
                continue;
            }
            if(buckets[i].min - leftMax > maxDifference){
                maxDifference = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDifference;
    }
}
```

### 4.如何用栈实现队列

用栈实现一个队列，基本的操作有：入栈、出栈。

解法：

用两个栈来实现队列，一个栈只负责入队，另一个栈只负责出队。

```java
public class QueueByStack {

    private Stack<Integer> enQueue = new Stack<Integer>();
    private Stack<Integer> deQueue = new Stack<Integer>();

    public void enQueue(int data){
        enQueue.push(data);

    }

    public Integer deQueue(){
        if(enQueue.isEmpty() && deQueue.isEmpty()){
            return null;
        }
        if(deQueue.isEmpty()){
            while (!enQueue.isEmpty()){
                deQueue.push(enQueue.pop());
            }
        }
        return deQueue.pop();
    }
}
```

### 5.寻找全排列的下一个数

给出一个数，找出一个数的全排序的下一个数（找到一个大于且仅大于原数的数）。

解法：

```java
public class NearestNumber {

    public static Integer findNearestNumber(int num){
        int []numbers;
        String numTemp = String.valueOf(num);
        numbers = new int[numTemp.length()];
        //数字转换为数组更好操作
        for(int i = 0;i < numTemp.length();i++){
            numbers[i] = Integer.valueOf(numTemp.charAt(i)-'0');
        }

        //找到数字交换的边界
        int index = findTransferBorder(numbers);
        if(index == 0){
            return null;
        }
        //交换数字
        exchangeNumber(numbers,index);
        //将倒序数字换为正序
        reverse(numbers,index);
        return output(numbers);
    }

    private static int findTransferBorder(int []numbers){
        for(int i = numbers.length-1;i > 0;i--){
            if(numbers[i] > numbers[i-1]){
                return i;
            }
        }
        return 0;
    }

    private static void exchangeNumber(int []numbers,int index){
        int head = numbers[index-1];
        for(int i = numbers.length-1;i > 0;i--){
            if(numbers[i] > head){
                numbers[index-1] = numbers[i];
                numbers[i] = head;
                break;
            }
        }
    }

    private static void reverse(int []numbers,int index){
        for(int i = index,j = numbers.length-1;i < j;i++,j--){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    private static Integer output(int []numbers){
        Integer result = 0;
        int power = numbers.length-1;
        for(int i = 0;i < numbers.length;i++){
            int temp = (int)Math.pow(10,power);
            result += (numbers[i]*temp);
            power--;
        }
        return  result;
    }
}
```



### 6.删去K个数字后的最小值

给出一个数字，从该数中删除掉k个数字，要求剩下的数字尽可能的小，该如何 选取被删除的数字？

```java
public class DeleteKNumbers {

    public static String removeKNumbersResult(String num,int k){
        if(k >= num.length()){
            return "0";
        }
        int newLength = num.length()-k;
        char []charStack = new char[newLength];
        int top = 0;
        for(int i = 0;i < num.length();++i){
            char c = num.charAt(i);
            while (top > 0 && charStack[top-1] > c && k > 0){
                top -= 1;
                k -=1;
            }
            charStack[top++] = c;
        }
        //记录开头有多少个0
        int offset = 0;
        while (offset < newLength && charStack[offset] == '0'){
            offset++;
        }
        return offset == newLength ? "0" : new String(charStack,offset,newLength-offset);
    }
}
```

### 7.如何实现大整数相加

给出两个很大的整数，要求实现程序 求出两个整数之和。

解法：

```java
public class BigIntegerAddition {

    public static String bigIntegerAddition(String a,String b){
        int maxLength = a.length() > b.length() ? a.length() : b.length();
        //将大数存入数组中（最左边的数是大数的最低位数）
        int []newArrayA = new int[maxLength+1];
        for(int i = 0;i < a.length();i++){
            newArrayA[i] = a.charAt(a.length()-i-1)-'0';
        }
        int []newArrayB = new int[maxLength+1];
        for(int i = 0;i < b.length();i++){
            newArrayB[i] = b.charAt(b.length()-i-1)-'0';
        }
        //对两个数组从左到右进行相加
        int []result = new int[maxLength + 1];
        for(int i = 0;i < result.length;i++){
            int temp = result[i];
            temp += newArrayA[i];
            temp += newArrayB[i];
            if(temp >= 10){
                result[i+1] = result[i+1]+1;
                temp -= 10;
            }
            result[i] = temp;
        }
        //拼相加结果
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFirst = false;
        for(int i = result.length-1;i >= 0;i--){
            if(!isFirst){
                if(result[i]==0){
                    continue;
                }
                isFirst = true;
            }
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }
}
```



### 8.如何求解金矿问题

很久很久以前，有一位国王拥有5座金矿，每夜金矿的黄金含量不同，需要参与挖掘的工人人数也不同。例如有的金矿含量是500kg黄金，需要5个工人来挖掘，有的金矿含量是200kg，需要3个工人来挖掘······

如果参与挖矿的工人的总数是10。每夜金矿要么全挖，要么不挖，不能派出一半人挖取 一半的金矿。要求用程序 求出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？

200kg黄金/3人

300kg黄金/4人

350kg黄金/3人

400kg黄金/5人

500kg黄金/5人

解法：

反问题转化成指定工人数量（w）和指定金矿数量（n）的问题(**状态转移方程式**)：F(n) = (n,w)（n=0或w=0）

```java
public class GoldMiner {

    public static int getTheBestGoldMinerPlan(int w,int n,int []p,int []g){
        if(w == 0 || n ==0){
            return 0;
        }
        if(w < p[n-1]){
            return getTheBestGoldMinerPlan(w,n-1,p,g);
        }
        return Math.max(getTheBestGoldMinerPlan(w,n-1,p,g),getTheBestGoldMinerPlan(w-p[n-1],n-1,p,g)+g[n-1]);
    }

    public static int getTheBestGoldMinerPlanV2(int w,int n,int []p,int []g){
        int []plans = new int[w+1];
        for(int i = 1;i <= g.length;i++){
            for(int j = w;j >= 1;j--){
                if(j >= p[i-1]){
                    plans[j] = Math.max(plans[j],plans[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return plans[w];
    }
}
```



### 9.寻找缺失的整数

在一个无序 数组里有99个不重复的正整数，范围是1~100，唯独缺少一个1~100中的整数。如何 找出这个缺失的整数？

扩展：

1.一个无序数组里有若干个正整数，范围是1~100，其中99个数都出现了偶数次，只有1个数出现了奇次数，如何找到这个出现奇次数次的数？

2.一个无序数组里有若干个正整数，范围是1~100，其中98个数都出现了偶数次，有2个数出现了奇次数，如何找到这两个出现奇次数次的数？

解法：

异或运算：相同为1，不同为0。

```java
public class FindNumbers {
    
    public static int[] findLostNumbers(int []num,int resultNum){
        int []result = new int[resultNum];
        int xorResult = 0;
        for(int i = 0;i < num.length;i++){
            xorResult ^= num[i];
        }
        //异或结果为0，说明不存在两个奇数次数的数
        if(xorResult == 0){
            return null;
        }
        //确定两个数的不同位
        int xorSeparator = 1;
        while (0 == (xorSeparator&xorResult)){
            xorSeparator <<= 1;
        }
        for(int i = 0;i < num.length;i++){
            if(0 == (num[i]&xorSeparator)){
                result[0] ^= num[i];
            }else {
                result[1] ^= num[i];
            }
        }
        return result;
    }
}
```



