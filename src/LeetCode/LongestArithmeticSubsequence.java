package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {
        int maxSubsequenceCount = 2;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sequence = nums[j]-nums[i];
                maxSubsequenceCount = Math.max(maxSubsequenceCount,subsequenceCount(nums,j,sequence));
            }
        }
        return maxSubsequenceCount;
    }
    int subsequenceCount(int[] nums, int start, int sequenceValue){
        int count = 2;
        int lastElement = nums[start];
        for (int i = start+1; i < nums.length; i++) {
            if (nums[i]-lastElement==sequenceValue){
                count++;
                lastElement = nums[i];
            }
        }
        return count;
    }
    public int dynamicProgrammingApproach(int[] nums){
        HashMap<Integer,Integer>[] hashMaps = new HashMap[nums.length];
        int maxCount = 2;
        for (int right = 0; right < nums.length; right++) {
            hashMaps[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int difference = nums[right] - nums[left];
                hashMaps[right].put(difference,hashMaps[left].getOrDefault(difference,1)+1);
                maxCount = Math.max(maxCount,hashMaps[right].get(difference));
            }
        }
        return maxCount;
    }
}
