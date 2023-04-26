package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class UniquePaths {
    private int memoaization[][];
    public int uniquePaths(int m, int n) {
        memoaization = new int[m][n];
        uniquePathsRecursive(m,n,0,0);
        System.out.println(Arrays.deepToString(memoaization));
        return memoaization[0][0];
    }

    public int uniquePathsRecursive(int m, int n, int currentM, int currentN) {
        if(memoaization[currentM][currentN]!=0)return memoaization[currentM][currentN];
        if(currentM==m-1 && currentN==n-1) memoaization[currentM][currentN]=1;
        else if(currentM==m-1) memoaization[currentM][currentN] = uniquePathsRecursive(m,n,currentM,currentN+1);
        else if(currentN==n-1) memoaization[currentM][currentN] = uniquePathsRecursive(m,n,currentM+1,currentN);
        else memoaization[currentM][currentN] = uniquePathsRecursive(m,n,currentM+1,currentN) + uniquePathsRecursive(m,n,currentM,currentN+1);
        return memoaization[currentM][currentN];
    }

    public int bottomUpApproach(int m, int n){
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        for (int i = m-2; i>=0 ; i--) {
            for (int j = n-2; j>=0 ; j--) {
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println(up.uniquePaths(3,7));
        System.out.println(up.bottomUpApproach(3,7));
    }
}
