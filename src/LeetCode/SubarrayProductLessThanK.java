package LeetCode;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0, end=0;
        int product=1;
        int subArrayCount=0;
        while(end<nums.length){
            product*=nums[end];
            while (start<end && product>=k){
                product/=nums[start];
                start++;
            }
            if(product<k){
                subArrayCount += end-start+1;
            }
            end++;
        }
        return subArrayCount;
    }
}
