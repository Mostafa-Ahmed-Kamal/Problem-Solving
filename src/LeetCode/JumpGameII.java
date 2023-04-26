package LeetCode;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n-2; i >= 0 ; i--) {
            int end=Math.min(n-1,i+nums[i]);
            int min = n;
            for (int j = i+1; j <= end; j++) {
                min = Math.min(min,dp[j]);
            }
            dp[i] = min+1;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        JumpGameII jg2 = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(jg2.jump(nums));
    }
}
