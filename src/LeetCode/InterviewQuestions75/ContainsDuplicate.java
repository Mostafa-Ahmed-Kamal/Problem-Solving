package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    /// O(nlgn)time O(1)space
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1])return true;
        }
        return false;
    }
    /// O(n)time O(n)space
    public boolean BetterSolution(int[] nums){
        HashSet<Integer> map = new HashSet<>();
        for (int num:nums) {
            if(!map.add(num))return true;
        }
        return false;
    }
}
