package com.tinyorangecat.datastruct.chain.test;

public class TheChain {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }

        @Override
        public String toString(){
            return String.valueOf(data);
        }
    }

    private Node head;
    private Node last;
    private int size;

    public void insertChain(int data,int index)throws Exception{
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("超出链表节点范围！！");
        }
        Node insertedNode = new Node(data);
        if(size == 0){
            head = insertedNode;
            last = insertedNode;
        }else if(index == 0){
            insertedNode.next = head;
            head = insertedNode;
        }else if(index == size){
            last.next = insertedNode;
            last = insertedNode;
        }else{
            Node temp = get(index-1);
            insertedNode.next = temp.next;
            temp.next = insertedNode;
        }
        size++;
    }

    public Node deleteChain(int index)throws Exception{

        if(index >= size || index <0){
            throw new IndexOutOfBoundsException("超出链表节点！！");
        }
        Node deletedNode = null;
        if(index == 0){
            deletedNode = head;
            head = head.next;
        }else if(index == size-1){
            deletedNode = last;
            Node lastNode = get(index - 1);
            lastNode.next = null;
            last = lastNode;
        }else{
            Node lastNode = get(index - 1);
            deletedNode = lastNode.next;
            lastNode.next = lastNode.next.next;
        }
        size--;
        return deletedNode;
    }

    public Node get(int index){
        Node tempt = head;
        Node result = null;
        int count = 0;
        while (tempt != null){
            if(count == index){
                result = tempt;
                break;
            }
            count++;
            tempt = tempt.next;
        }
        return result;
    }

    public void output(){
        Node temp = head;
        int count = 0;
        System.out.println("The chain node size : "+size);
        System.out.print("The chain [");
        while (temp != null){
            count++;
            System.out.print(temp.data);
            if(count != size){
                System.out.print(",");
            }
            temp = temp.next;
        }
        System.out.println("].");
    }
}
