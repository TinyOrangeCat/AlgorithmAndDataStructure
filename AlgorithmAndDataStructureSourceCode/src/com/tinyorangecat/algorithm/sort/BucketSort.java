package com.tinyorangecat.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/1 16:42
     * @Description Sort the arrays form small to large by bucket sort.
     * @Param array The type of the array id double.
     * @Return void
     **/
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
