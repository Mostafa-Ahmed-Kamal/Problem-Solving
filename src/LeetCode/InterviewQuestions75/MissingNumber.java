package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=0)return 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1]-1)return nums[i]+1;
        }
        return nums.length;
    }

    public int betterSolution(int[] nums){
        int xorAll = 0;
        for (int i = 0; i < nums.length ; i++) {
            xorAll ^= i^nums[i];
        }
        return xorAll^nums.length;
    }

    // not better if the sum of all values is extra extra large tho
    public int anotherSolution(int[] nums){
        int n = nums.length;
        int Expectedsum = n*(n+1)/2;
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        return Expectedsum - sum;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int nums[] = {0,1,5,4,3,2};
        System.out.println(mn.missingNumber(nums));
        System.out.println(mn.betterSolution(nums));
        System.out.println(mn.anotherSolution(nums));
    }
}
