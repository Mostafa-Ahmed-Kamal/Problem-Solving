package LeetCode.HardProblems;

import java.util.HashMap;

public class MaximizeScoreAfterNOperations {
    int[][] gcdPairs;
    int n;
    HashMap<Integer,Integer> dp;
    public int maxScore(int[] nums) {
        dp = new HashMap<>();
        n = nums.length;
        gcdPairs = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                gcdPairs[i][j] = gcd(nums[i],nums[j]);
            }
        }
        return maxScoreDp(nums,1,0);
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private int maxScoreDp(int[] nums, int iterationCount, int bitmask){
        if (dp.containsKey(bitmask))return dp.get(bitmask);
        if (iterationCount>n)return 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if ((bitmask & (1<<i))==(1<<i))continue;
            for (int j = i+1; j < n; j++) {
                if ((bitmask & (1<<j))==(1<<j))continue;
                int ijBits = (1<<i) + (1<<j);
                int iterationMax = iterationCount*gcdPairs[i][j]+maxScoreDp(nums,iterationCount+1,bitmask+ijBits);
                max = Math.max(max,iterationMax);
            }
        }
        dp.put(bitmask,max);
        return max;
    }

    public static void main(String[] args) {
        MaximizeScoreAfterNOperations ms = new MaximizeScoreAfterNOperations();
        int[] nums = {415,230,471,705,902,87};
        System.out.println(ms.maxScore(nums));
    }
}
