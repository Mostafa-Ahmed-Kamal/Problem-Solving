package LeetCode;

import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer,Integer> dp;
    public int climbStairs(int n) {
        dp = new HashMap<>();
        return climStairsRecursive(n);
    }
    private int climStairsRecursive(int n){
        if(dp.containsKey(n))return dp.get(n);
        if(n==0) return 1;
        if(n<0) return 0;
        int ways = climStairsRecursive(n-1) + climStairsRecursive(n-2);
        dp.put(n,ways);
        return ways;
    }
}
