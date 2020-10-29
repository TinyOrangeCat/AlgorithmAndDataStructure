package com.tinyorangecat.algorithm.interview.test;

import com.tinyorangecat.algorithm.interview.GoldMiner;
import org.junit.Test;

import java.util.Arrays;

public class GoldMinerTest {

    @Test
    public void getTheBestGoldMinerPlanTest(){
        int work = 10;
        int []miners = {500,400,350,300,200};
        int []plan = {5,5,3,4,3};
        System.out.println(work+" works digs "+ Arrays.toString(miners)+" (need workers : "+Arrays.toString(plan)+"),the best plans is :"+ GoldMiner.getTheBestGoldMinerPlan(work,miners.length,plan,miners));
    }

    @Test
    public void getTheBestGoldMinerPlanTestV2(){
        int work = 10;
        int []miners = {500,400,350,300,200};
        int []plan = {5,5,3,4,3};
        System.out.println("V2: "+work+" works digs "+ Arrays.toString(miners)+" (need workers : "+Arrays.toString(plan)+"),the best plans is :"+ GoldMiner.getTheBestGoldMinerPlanV2(work,miners.length,plan,miners));
    }

    @Test
    public void reviewTest(){
        int work = 10;
        int []miners = {500,400,350,300,200};
        int []plan = {5,5,3,4,3};
        System.out.println("Review : V1: "+work+" works digs "+ Arrays.toString(miners)+" (need workers : "+Arrays.toString(plan)+"),the best plans is :"+ ReviewGoldMiner.getTheBestGoldPlanV1(work,miners.length,miners,plan));
        System.out.println("Review : V2: "+work+" works digs "+ Arrays.toString(miners)+" (need workers : "+Arrays.toString(plan)+"),the best plans is :"+ ReviewGoldMiner.getTheBestGoldPlanV2(work,miners.length,miners,plan));
    }
}
