package LeetCode.InterviewQuestions75;
public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        int currentMin = 1, currentMax = 1;
        int maxProduct = nums[0];
        boolean doesZeroExist = false;
        for(int num:nums){
            if(num==0){
                currentMax=1;
                currentMin=1;
                doesZeroExist = true;
            }
            else{
                int temp = currentMax*num;
                currentMax = Math.max(num, Math.max(currentMin*num, currentMax*num));
                currentMin = Math.min(num, Math.min(currentMin*num, temp));
                maxProduct = Math.max(maxProduct,currentMax);
            }
        }
        return doesZeroExist? Math.max(maxProduct,0):maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubArray mpsq = new MaximumProductSubArray();
        int nums[] = {2,3,-2,4,-1};
        /*
        max,min,maxproduct
        1,1,2
        2,1,2           2
        6,1,6           3
        6,-12,6         -2
        6,-48,          4
        ,-8             5
                        -1
         */
        System.out.println(mpsq.maxProduct(nums));
    }
}
