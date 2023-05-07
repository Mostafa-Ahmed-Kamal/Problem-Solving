package LeetCode;

import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        final double MOD = Math.pow(10,9)+7;
        int start=0, end=nums.length-1;
        int subSequenceCount = 0;
        int[] powers = new int[nums.length];
        powers[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powers[i]= (int) ((powers[i-1]*2)%MOD);
        }
        while(start<=end){
            if (nums[end]+nums[start]<=target){
                subSequenceCount = (int) ((subSequenceCount + powers[end-start])%MOD);
                start++;
            }
            else{
                end--;
            }
        }
        return (int)(subSequenceCount%MOD);
    }

    public static void main(String[] args) {
        NumberOfSubsequencesThatSatisfyTheGivenSumCondition ns = new NumberOfSubsequencesThatSatisfyTheGivenSumCondition();
        int nums[] = {9,25,9,28,24,12,17}, target = 32;
        System.out.println(ns.numSubseq(nums,target));
    }
}
