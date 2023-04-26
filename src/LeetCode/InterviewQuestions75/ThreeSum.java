package LeetCode.InterviewQuestions75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            twoSumSorted(nums, result, i);
        }
        return result;
    }
    public void twoSumSorted(int[] nums, List<List<Integer>> result, int FirstElementIndex){
        int left = FirstElementIndex+1, right = nums.length-1;
        while(left<right){
            int sum = nums[FirstElementIndex] + nums[left] + nums[right];
            if(sum<0){
                left++;
            }
            else if(sum>0){
                right--;
            }
            // sum==0 which is what we need
            else{
                List<Integer> solution = new LinkedList<>();
                solution.add(nums[FirstElementIndex]);
                solution.add(nums[right]);
                solution.add(nums[left]);
                result.add(solution);
                do{
                    left++;
                }
                while(nums[left]==nums[left-1] && left<right);
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4}; // {-4,-1,-1,0,1,2}
        System.out.println(ts.threeSum(nums));
    }
}
