package com.tinyorangecat.algorithm.interview.test;

public class ReviewGoldMiner {

    public static int getTheBestGoldPlanV1(int w,int p,int []gold,int []plans){
        if(w == 0 || p == 0){
            return 0;
        }
        if(w < plans[p-1]){
            return getTheBestGoldPlanV1(w,p-1,gold,plans);
        }
        return Math.max(getTheBestGoldPlanV1(w,p-1,gold,plans),getTheBestGoldPlanV1(w-plans[p-1],p-1,gold,plans)+gold[p-1]);
    }
    public static int getTheBestGoldPlanV2(int w,int p,int []gold,int []plans){
        if(w == 0 || p == 0){
            return 0;
        }
        int []result = new int[w+1];
        for(int i = 1;i < gold.length;i++){
            for(int j = w;j >= 1;j--){
                if(j >= plans[i-1]){
                    result[j] = Math.max(result[j],result[j-plans[i-1]]+gold[i-1]);
                }
            }
        }
        return result[w];
    }
}
