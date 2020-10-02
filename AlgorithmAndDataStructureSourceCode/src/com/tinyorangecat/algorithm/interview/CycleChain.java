package com.tinyorangecat.algorithm.interview;

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

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/2 11:47
     * @Description Judge a chain has a cycle or not.
     * @Param chain
     * @Return boolean
     **/
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

}
