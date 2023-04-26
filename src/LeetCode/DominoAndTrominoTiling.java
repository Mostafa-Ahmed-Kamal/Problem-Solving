package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        int MOD_NUM = (int)Math.pow(10,9)+7;
        if(n<=2)return 1;
        int[] dp = new int[n+1];
        dp[0]=1; dp[1]=1; dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (2*dp[i-1] + dp[i-3])%MOD_NUM;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DominoAndTrominoTiling dt = new DominoAndTrominoTiling();
        int n = 5;
        System.out.println(dt.numTilings(n));
    }
}
