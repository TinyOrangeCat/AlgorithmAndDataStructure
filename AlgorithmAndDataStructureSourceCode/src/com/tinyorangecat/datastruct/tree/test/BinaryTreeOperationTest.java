package com.tinyorangecat.datastruct.tree.test;

import com.tinyorangecat.datastruct.tree.MyBinaryTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeOperationTest {

    private MyBinaryTree.BinaryTreeNode buildBinaryTree(){
        LinkedList<Integer> treeData = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        MyBinaryTree.BinaryTreeNode binaryTreeNode = new MyBinaryTree().createBinaryTree(treeData);
        return binaryTreeNode;
    }

    @Test
    public void preOrderBinaryTree(){
        System.out.println("Pre-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.preOrderTraversal(tree);
        System.out.println("");
    }

    @Test
    public void preOrderBinaryTreeByStack(){
        System.out.println("Stack Pre-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.preOrderTraversalByStack(tree);
        System.out.println("");
    }

    @Test
    public void midOrderBinaryTree(){
        System.out.println("Mid-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.midOrderTraversal(tree);
        System.out.println("");
    }
    @Test
    public void midOrderBinaryTreeByStack(){
        System.out.println("Stack Mid-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.midOrderTraversalByStack(tree);
        System.out.println("");
    }

    @Test
    public void postOrderBinaryTree(){
        System.out.println("Post-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.postOrderTraversal(tree);
        System.out.println("");
    }

    @Test
    public void postOrderBinaryTreeByStack(){
        System.out.println("Stack Post-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.postOrderTraversalByStack(tree);
        System.out.println("");
    }

    @Test
    public void levelOrderBinaryTree(){
        System.out.println("Level-Order:");
        MyBinaryTree.BinaryTreeNode tree = buildBinaryTree();
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.levelOrderTraversal(tree);
        System.out.println("");
    }

    @Test
    public void reviewTest(){
        LinkedList<Integer> treeData = new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TheBinaryTree theBinaryTree = new TheBinaryTree();
        TheBinaryTree.BinaryTree binaryTree = theBinaryTree.creatBinaryTree(treeData);
        System.out.println("Review pre-order: ");
        theBinaryTree.preOrderTraverse(binaryTree);
        System.out.println();
        System.out.println("Review pre-order by stack: ");
        theBinaryTree.preOrderTraverseByStack(binaryTree);
        System.out.println();
        System.out.println("Review mid-order: ");
        theBinaryTree.midOrderTraverse(binaryTree);
        System.out.println();
        System.out.println("Review mid-order by stack: ");
        theBinaryTree.midOrderTraverseByStack(binaryTree);
        System.out.println();
        System.out.println("Review post-order: ");
        theBinaryTree.postOrderTraverse(binaryTree);
        System.out.println();
        System.out.println("Review level-order: ");
        theBinaryTree.levelOrderTraverse(binaryTree);
        System.out.println();
    }
}
