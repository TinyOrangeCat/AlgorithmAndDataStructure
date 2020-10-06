package com.tinyorangecat.algorithm.interview;

public class GoldMiner {

    /**
     * @Author TinyOrangeCat
     * @Date q 12:50
     * @Description Get the best gold miner plan.
     * @Param w
     * @Param n
     * @Param p
     * @Param g
     * @Return
     **/
    public static int getTheBestGoldMinerPlan(int w,int n,int []p,int []g){
        if(w == 0 || n ==0){
            return 0;
        }
        if(w < p[n-1]){
            return getTheBestGoldMinerPlan(w,n-1,p,g);
        }
        return Math.max(getTheBestGoldMinerPlan(w,n-1,p,g),getTheBestGoldMinerPlan(w-p[n-1],n-1,p,g)+g[n-1]);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/6 14:20
     * @Description Get the best gold miner plan.
     * @Param w
     * @Param n
     * @Param p
     * @Param g
     * @Return
     **/
    public static int getTheBestGoldMinerPlanV2(int w,int n,int []p,int []g){
        int []plans = new int[w+1];
        for(int i = 1;i <= g.length;i++){
            for(int j = w;j >= 1;j--){
                if(j >= p[i-1]){
                    plans[j] = Math.max(plans[j],plans[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return plans[w];
    }
}
