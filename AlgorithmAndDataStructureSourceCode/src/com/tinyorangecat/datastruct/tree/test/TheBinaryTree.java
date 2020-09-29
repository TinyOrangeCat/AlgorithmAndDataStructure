package com.tinyorangecat.datastruct.tree.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TheBinaryTree {
    public static class BinaryTree{
        Integer data;
        BinaryTree leftNode;
        BinaryTree rightNode;

        public BinaryTree(Integer data){
            this.data = data;
        }

        @Override
        public String toString(){
            return String.valueOf(data);
        }
    }

    public BinaryTree creatBinaryTree(LinkedList<Integer> dataArray){
        BinaryTree binaryTree = null;
        if(dataArray == null || dataArray.isEmpty()){
            return null;
        }
        Integer data = dataArray.removeFirst();
        if(data != null){
            binaryTree = new BinaryTree(data);
            binaryTree.leftNode = creatBinaryTree(dataArray);
            binaryTree.rightNode = creatBinaryTree(dataArray);
        }
        return binaryTree;
    }

    public void preOrderTraverse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        System.out.print(binaryTree.data+" ");
        preOrderTraverse(binaryTree.leftNode);
        preOrderTraverse(binaryTree.rightNode);
    }

    public void preOrderTraverseByStack(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Stack<BinaryTree> binaryTreeStack = new Stack<BinaryTree>();
        while (binaryTree != null || !binaryTreeStack.isEmpty()){
            while (binaryTree != null){
                System.out.print(binaryTree.data+" ");
                binaryTreeStack.push(binaryTree);
                binaryTree = binaryTree.leftNode;
            }
            if(!binaryTreeStack.isEmpty()){
                binaryTree = binaryTreeStack.pop();
                binaryTree = binaryTree.rightNode;
            }
        }
    }

    public void midOrderTraverse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        midOrderTraverse(binaryTree.leftNode);
        System.out.print(binaryTree.data+" ");
        midOrderTraverse(binaryTree.rightNode);
    }

    public void midOrderTraverseByStack(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Stack<BinaryTree> binaryTreeStack = new Stack<BinaryTree>();
        while (binaryTree != null || !binaryTreeStack.isEmpty()){
            while (binaryTree != null){
                binaryTreeStack.push(binaryTree);
                binaryTree = binaryTree.leftNode;
            }
            if(!binaryTreeStack.isEmpty()){
                binaryTree = binaryTreeStack.pop();
                System.out.print(binaryTree.data+" ");
                binaryTree = binaryTree.rightNode;
            }
        }
    }

    public void postOrderTraverse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        postOrderTraverse(binaryTree.leftNode);
        postOrderTraverse(binaryTree.rightNode);
        System.out.print(binaryTree.data+" ");
    }

    public void levelOrderTraverse(BinaryTree binaryTree){
        if(binaryTree == null){
            return;
        }
        Queue<BinaryTree> binaryTreeQueue = new LinkedList<BinaryTree>();
        binaryTreeQueue.offer(binaryTree);
        while(!binaryTreeQueue.isEmpty()){
            BinaryTree temp = binaryTreeQueue.poll();
            System.out.print(temp.data+" ");
            if(temp.leftNode!= null){
                binaryTreeQueue.offer(temp.leftNode);
            }
            if(temp.rightNode != null){
                binaryTreeQueue.offer(temp.rightNode);
            }
        }
    }
}
