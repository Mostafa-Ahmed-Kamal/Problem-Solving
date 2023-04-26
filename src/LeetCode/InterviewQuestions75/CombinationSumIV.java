package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int dp[] = new int[target+1];
        dp[0]= 1;
        for (int i = 1; i < target+1; i++) {
            for (int num:nums){
                if(num<=i) dp[i]+=dp[i-num];
                else break;
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIV cs4 = new CombinationSumIV();
        int nums[] = {1,2,3};
        System.out.println(cs4.combinationSum4(nums,4));
    }
}
