package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class JumpGame {

    public boolean canJump(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[nums.length-1]=true;
        for (int i = nums.length-2; i >= 0 ; i--) {
            int end = Math.min(nums.length, i+nums[i]);
            for (int j = i+1; j <= end ; j++) {
                if(dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public boolean betterSolution(int[] nums){
        int endGoal = nums.length-1;
        for (int i = nums.length-2; i >= 0 ; i--) {
            endGoal = endGoal <= i+nums[i]? i : endGoal;
        }
        return endGoal==0;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int nums[] = {2,3,1,1,4};
        System.out.println(jg.canJump(nums));
        System.out.println(jg.betterSolution(nums));
    }

}
