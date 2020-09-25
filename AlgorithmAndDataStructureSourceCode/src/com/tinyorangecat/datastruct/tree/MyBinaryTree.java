package com.tinyorangecat.datastruct.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree {

    public static class BinaryTreeNode{
        int data;
        private BinaryTreeNode leftNode;
        private BinaryTreeNode rightNode;

        BinaryTreeNode(int data){
            this.data = data;
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:05
     * @Description Create a binary tree.
     * @Param binaryTreeArray The data in this LinkedList will be used to create a binary tree.
     * @Return BinaryTreeNode A binary tree.
     **/
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by front order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
    public void preOrderTraversal(BinaryTreeNode tree){//前序遍历
        if(tree == null){
            return;
        }
        System.out.print(tree.data+" ");
        preOrderTraversal(tree.leftNode);
        preOrderTraversal(tree.rightNode);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by front order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by middle order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
    public void midOrderTraversal(BinaryTreeNode tree){//中序遍历
        if(tree == null){
            return;
        }
        midOrderTraversal(tree.leftNode);
        System.out.print(tree.data+" ");
        midOrderTraversal(tree.rightNode);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by middle order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by post order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
    public void postOrderTraversal(BinaryTreeNode tree){//后序遍历
        if(tree == null){
            return;
        }
        postOrderTraversal(tree.leftNode);
        postOrderTraversal(tree.rightNode);
        System.out.print(tree.data+" ");
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by post order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
    public void postOrderTraversalByStack(BinaryTreeNode tree){//后序遍历，未完待续。。。
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
                tree = tree.rightNode;
                if(tree != null)
                    System.out.print(tree.data+" ");
            }
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/25 14:09
     * @Description Traverse the binary tree by level order.
     * @Param tree The binary tree that will be traversed.
     * @Return void
     **/
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
}
