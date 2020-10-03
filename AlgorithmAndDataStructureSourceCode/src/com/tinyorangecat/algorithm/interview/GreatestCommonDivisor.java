package com.tinyorangecat.algorithm.interview;

public class GreatestCommonDivisor {

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 11:29
     * @Description Get the greatest common division.
     * @Param a
     * @Param b
     * @Return int
     **/
    public static int getGreatestCommonDivisor1(int a,int b){
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big % small == 0){
            return small;
        }
        for(int i = small/2;i > 1;i--){
            if(big % i == 0 && small % i ==0){
                return i;
            }
        }
        return 1;
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 12:01
     * @Description Get the greatest common division by division algorithm.
     * @Param a
     * @Param b
     * @Return
     **/
    public static int getGreatestCommonDivisor2(int a,int b){
        //辗转相除法（欧几里德法，整数a和b(a>b)的最大公约数等于，a和b的相除的余数c和最小数b的最大公约数）
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big % small == 0){
            return small;
        }
        return getGreatestCommonDivisor2(big % small,small);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 12:42
     * @Description Get the greatest common division by the Nine Chapters of Mathematical Procedures.
     * @Param a
     * @Param b
     * @Return
     **/
    public static int getGreatestCommonDivisor3(int a,int b){
        //更相减损术（整数a和b(a>b)的最大公约数等于，a和b的差值c和最小数b的最大公约数）
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big == small){
            return big;
        }
        return getGreatestCommonDivisor3(big-small,small);
    }

    /**
     * @Author TinyOrangeCat
     * @Date 2020/10/3 12:54
     * @Description Get the greatest common division.
     * @Param a
     * @Param b
     * @Return
     **/
    public static int getGreatestCommonDivisor4(int a,int b){
        //辗转相除法+更相减损术
        //&运算：同1则1，否则为0
        int big = a > b ? a : b;
        int small = b < a ? b : a;
        if(big == small){
            return big;
        }
        if((big & 1) == 0 && (small&1) == 0){
            return getGreatestCommonDivisor4(big>>1,small >>1)<<1;
        }else if((big & 1) == 0 && (small&1) != 0){
            return getGreatestCommonDivisor4(big>>1,small);
        }else if((big & 1) != 0 && (small&1) == 0){
            return getGreatestCommonDivisor4(big,small>>1);
        }else{
            return getGreatestCommonDivisor4(big-small,small);
        }
    }
}
