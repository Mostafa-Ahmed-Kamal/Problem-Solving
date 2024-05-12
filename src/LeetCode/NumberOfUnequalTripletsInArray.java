package LeetCode;

public class NumberOfUnequalTripletsInArray {
    public int unequalTriplets(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]!=nums[j] && nums[i]!=nums[k] && nums[j]!=nums[k]) result+=1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfUnequalTripletsInArray nua = new NumberOfUnequalTripletsInArray();
        int result = nua.unequalTriplets(new int[] {4,4,4,3,2,1});
        System.out.println(result);
    }
}
