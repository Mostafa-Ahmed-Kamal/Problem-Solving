package LeetCode;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num:nums){
                sum += (num>>i & 1);
            }
            sum%=3;
            xor += (sum<<i);
        }
        return xor;
    }

    public static void main(String[] args) {
        SingleNumberII sn2 = new SingleNumberII();
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(sn2.singleNumber(nums));
    }
}
