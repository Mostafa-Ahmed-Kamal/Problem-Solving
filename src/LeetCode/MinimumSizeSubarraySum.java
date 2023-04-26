package LeetCode;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0,end=0;
        int minSize = Integer.MAX_VALUE;
        int currentSum=0;
        while(end<nums.length){
            currentSum+=nums[end];
            if(currentSum>=target){
                while(start<=end && currentSum>=target){
                    minSize = Math.min(minSize,end-start+1);
                    currentSum-=nums[start];
                    start++;
                }
            }
            end++;
        }
        return minSize==Integer.MAX_VALUE? 0:minSize;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum mss = new MinimumSizeSubarraySum();
        int target = 7, nums[] = {2,3,1,2,4,3};
        System.out.println(mss.minSubArrayLen(target,nums));
    }
}
