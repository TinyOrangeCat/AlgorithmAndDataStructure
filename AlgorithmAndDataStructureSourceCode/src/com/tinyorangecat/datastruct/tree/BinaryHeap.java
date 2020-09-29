package com.tinyorangecat.datastruct.tree;

public class BinaryHeap {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/27 13:40
     * @Description Transform an array to binary heap.
     * @Param array The array that needs to be transformed.
     * @Return void
     **/
    public static void buildBinaryHeap(int []array){
        for(int i = (array.length-2)/2;i >= 0;i--){//从最后一个非叶子节点开始下沉
            goDown(array,i,array.length);
        }
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/27 13:55
     * @Description Floating forward a binary heap.
     * @Param array A binary heap.
     * @Return void
     **/
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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/9/27 13:59
     * @Description Go down a binary heap.
     * @Param array The array that needs to be adjusted.
     * @Param parentIndex The parent index of a child tree.
     * @Param length The numbers of heap's elements.
     * @Return void
     **/
    public static void goDown(int []array,int parentIndex,int length){
        int temp = array[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < length){
            if(childIndex+1 < length && array[childIndex+1] < array[childIndex]){//找到最小的孩子节点(右孩子应小于左孩子）
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
}
