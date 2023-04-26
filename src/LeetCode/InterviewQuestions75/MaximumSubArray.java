package LeetCode.InterviewQuestions75;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        /// O(n) solution
        if(nums.length<2)return nums[0];
        int end=1;
        int sum=nums[0], maxSum=nums[0];
        while(end<nums.length){
            if (sum<0) {
                sum=0;
            }
            sum+=nums[end];
            maxSum= Math.max(maxSum,sum);
            end++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArray msa = new MaximumSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(msa.maxSubArray(nums));
    }
}
