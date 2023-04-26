package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return the indices of two numbers that sums to a given target, each input has only 1 solution and
 * you cant use the same index twice
 */
public class TwoSum {

    /// ONEPASS Algorithm (BEST)
    public int[] TwoSumOnePass(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = target-arr[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            else{
                map.put(arr[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(ts.TwoSumOnePass(nums, target)));

        nums = new int[]{2,1,5,3};
        target = 4;
        System.out.println(Arrays.toString(ts.TwoSumOnePass(nums, target)));
    }
}
