package com.tinyorangecat.datastruct.chain;

public class MyChain {
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 14:31
     * @Description Insert a data into the chain.
     * @Param index The position which will be inserted.
     * @Param data The data(should be the type of int) which will be inserted.
     * @Return void
     **/
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 15:34
     * @Description Delete a data in the chain.
     * @Param index The deleted data's position.
     * @Return Node The deleted Node.
     **/
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
//            deletedNode = lastNode;
//            lastNode = getChain(size-2);
//            lastNode.next = null;
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/23 15:06
     * @Description From the chain, get the target node by index.
     * @Param index The node's index in the chain.
     * @Return Node The deleted node.
     **/
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

}
