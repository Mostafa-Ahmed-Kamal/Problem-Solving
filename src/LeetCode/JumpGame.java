package LeetCode;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int canReachEndFrom = n-1;
        for (int i = n-2; i >= 0 ; i--) {
            if(i+nums[i] >= canReachEndFrom){
                canReachEndFrom = i;
            }
        }
        return canReachEndFrom==0;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = {3,2,1,0,4};
        System.out.println(jg.canJump(nums));
    }
}
