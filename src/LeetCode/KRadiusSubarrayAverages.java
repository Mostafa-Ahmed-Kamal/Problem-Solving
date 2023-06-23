package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public int[] getAverages(int[] nums, int k) {
        int[] averages = new int[nums.length];
        int subArraySize = 2*k+1;
        Arrays.fill(averages,-1);
        if (nums.length<subArraySize)return averages;
        long sum = 0;
        for (int i = 0; i < subArraySize-1; i++) {
            sum+=nums[i];
        }
        for (int i = k; i < nums.length-k; i++) {
            sum+= nums[i+k];
            averages[i] = (int)(sum/subArraySize);
            sum-= nums[i-k];
        }
        return averages;
    }

    public static void main(String[] args) {
        KRadiusSubarrayAverages kr = new KRadiusSubarrayAverages();
        int nums[] = {7,4,3,9,1,8,5,2,6}, k = 3;
        System.out.println(Arrays.toString(kr.getAverages(nums,k)));
    }
}
