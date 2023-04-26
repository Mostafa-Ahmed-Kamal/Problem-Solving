package LeetCode;

import java.util.Arrays;
import java.util.Formattable;

public class LongestSubsequenceWithLimitedSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int[] result = new int[queries.length];
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(queries));
        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(nums,0,nums.length-1,queries[i]);
        }
        return result;
    }
    private int binarySearch(int[] nums, int start, int end, int value){
        if(end==start+1){
            if(nums[end]<=value)return end+1;
            return nums[start]<=value?start+1:0;
        }
        if(end<=start)return nums[end]<=value?start+1:0;
        int mid = start + (end-start)/2;
        if(nums[mid]==value)return mid+1;
        if(nums[mid]>value){
            return binarySearch(nums,start,mid,value);
        }
        else{
            return binarySearch(nums,mid,end,value);
        }
    }

    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum ls = new LongestSubsequenceWithLimitedSum();
        int[] nums = {4,5,2,1}, queries = {3,10,21};
        System.out.println(Arrays.toString(ls.answerQueries(nums,queries)));
    }
}
