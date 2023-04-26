package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int result = 0;
        int memoaization[] = new int[n+1];
        memoaization[n] = 1;
        for (int i = 0; i < memoaization.length-1; i++) {
            memoaization[i]=-1;
        }
        climbStairsRecursive(memoaization, n,0);
        return memoaization[0];
    }
    private int climbStairsRecursive(int[] memoaization, int n, int currentStair){
        if(currentStair>n)return 0;
        if(memoaization[currentStair]==-1){
            memoaization[currentStair] = climbStairsRecursive(memoaization, n, currentStair+1)+climbStairsRecursive(memoaization, n, currentStair+2);
        }
        return memoaization[currentStair];
    }


    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(4));
    }
}
