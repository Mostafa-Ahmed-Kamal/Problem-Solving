package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.HashMap;

public class LongestIncreasingSubsequence {
    public static HashMap<Integer[],Integer> map = new HashMap<>();
    public int lengthOfLIS(int[] nums) {
        return lengthOfLISRecursive(nums, 0, 0, Integer.MIN_VALUE);
    }

    public int lengthOfLISRecursive(int[] nums, int start, int currentLength, int currentMin) {
        if(map.containsKey(new int[] {start,currentMin})) return map.get(new int[] {start,currentMin});
        while(start<nums.length && nums[start]<=currentMin)start++;
        if(start>=nums.length) return currentLength;
        int nextStart = start+1;
        while(nextStart<nums.length && nums[start]>=nums[nextStart]){
            nextStart++;
        }
        if (nextStart==nums.length) return Math.max(currentLength+1,lengthOfLISRecursive(nums, start+1, currentLength, currentMin));
        currentLength = Math.max(lengthOfLISRecursive(nums,nextStart,currentLength+1, nums[start]),lengthOfLISRecursive(nums, start+1, currentLength, currentMin));
        map.put(new Integer[] {start,currentMin}, currentLength);
        return currentLength;
    }

    public int betterSolutio(int[] nums){
        int dp[] = new int[nums.length];
        int max = 1;
        dp[nums.length-1]=1;
        for (int i = dp.length-2; i >=0 ; i--) {
            int currentMax = 1;
            for (int j = i+1; j < dp.length; j++) {
                if(nums[i]<nums[j]) {
                    currentMax = Math.max(currentMax, 1 + dp[j]);
                }
            }
            max = Math.max(max,currentMax);
            dp[i] = currentMax;
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence lss = new LongestIncreasingSubsequence();
        int nums[] = {10,9,2,5,3,7,101,18};
        //nums = new int[] {0,1,0,3,2,3};
        //nums = new int[] {7,7,7,7,7,7,7};
        //nums = new int[] {4,10,4,3,8,9};
        //nums = new int[] {1,3,6,7,9,4,10,5,6};
        System.out.println(lss.lengthOfLIS(nums));
        System.out.println(lss.betterSolutio(nums));
    }
}
