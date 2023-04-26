package LeetCode;

public class NumberOfZeroFilledSubarrays {

    public long zeroFilledSubarray(int[] nums) {
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                long zeroCount = 0;
                while(i<nums.length && nums[i]==0){
                    zeroCount++;
                    result+= zeroCount;
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays nof = new NumberOfZeroFilledSubarrays();
        int[] nums = {1,3,0,0,2,0,0,0,4};
        System.out.println(nof.zeroFilledSubarray(nums));
    }

}
