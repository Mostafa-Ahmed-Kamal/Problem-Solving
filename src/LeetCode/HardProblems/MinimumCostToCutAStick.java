package LeetCode.HardProblems;

import java.util.HashMap;

public class MinimumCostToCutAStick {
    HashMap<Integer,Integer> dp;
    private final int MAX_STICK_SIZE = (int) Math.pow(10,6)+1;
    public int minCost(int n, int[] cuts) {
        dp = new HashMap<>();
        return dp(0,n,cuts);
    }
    public int dp(int start, int end, int[] cuts){
        int key = start*MAX_STICK_SIZE + end;
        if (dp.containsKey(key))return dp.get(key);
        int cost = end-start;
        int minCost = Integer.MAX_VALUE;
        for (int cut:cuts){
            if (cut<=start || cut>=end)continue;
            int recursiveCutsCost = dp(start,cut,cuts) + dp(cut,end,cuts);
            minCost = Math.min(minCost,recursiveCutsCost);
        }
        int result = minCost==Integer.MAX_VALUE?0:cost+minCost;
        dp.put(key,result) ;
        return result;
    }

    public static void main(String[] args) {
        MinimumCostToCutAStick ms = new MinimumCostToCutAStick();
        int n = 7, cuts[] = {1,3,4,5};
        System.out.println(ms.minCost(n,cuts));
    }
}
