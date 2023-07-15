package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
        for (int i = arr.length-1; i >=0 ; i--) {
            int best = map.getOrDefault(difference+arr[i],0)+1;
            map.put(arr[i],best);
            max = Math.max(max,best);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestArithmeticSubsequenceOfGivenDifference gd = new LongestArithmeticSubsequenceOfGivenDifference();
        int arr[] = {1,2,3,4}, difference = 1;
        System.out.println(gd.longestSubsequence(arr,difference));
    }
}
