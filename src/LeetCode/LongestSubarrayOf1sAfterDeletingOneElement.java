package LeetCode;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int zerosCount = 0;
        int longestSubArray = 0;
        for (int i = 0; i < nums.length; i++) {
            zerosCount += (nums[i]+1)%2;
            while (zerosCount>1){
                zerosCount -= (nums[start]+1)%2;
                start++;
            }
            longestSubArray = Math.max(longestSubArray,i-start);
        }
        return longestSubArray==nums.length?longestSubArray-1:longestSubArray;
    }

    public static void main(String[] args) {
        LongestSubarrayOf1sAfterDeletingOneElement l1 = new LongestSubarrayOf1sAfterDeletingOneElement();
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(l1.longestSubarray(nums));
    }
}
