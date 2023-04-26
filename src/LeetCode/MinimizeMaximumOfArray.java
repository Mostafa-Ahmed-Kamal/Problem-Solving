package LeetCode;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        int max = 0;
        long totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum+=nums[i];
            max = Math.max(max,(int)Math.ceil((double)totalSum/(i+1)));
        }
        return max;
    }

    public static void main(String[] args) {
        MinimizeMaximumOfArray mna = new MinimizeMaximumOfArray();
        int[] nums = {13,13,20,0,8,9,9};
        System.out.println(mna.minimizeArrayValue(nums));
    }
}
