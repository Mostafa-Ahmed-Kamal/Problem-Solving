package LeetCode;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        if(Math.sqrt(n)==Math.floor(Math.sqrt(n)))return 1;
        int sqrtN = (int) Math.sqrt(n);
        int[] values = new int[sqrtN];
        for (int i = 1; i <= sqrtN; i++) {
            values[i-1] = (int) Math.pow(i,2);
        }
        System.out.println(Arrays.toString(values));
        int[] dp = new int[n+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < sqrtN; j++) {
                if(i-values[j]>=0){
                    dp[i] = Math.min(dp[i],dp[i-values[j]]+1);
                }
                else break;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        int n = 52;
        System.out.println(ps.numSquares(n));
    }
}
