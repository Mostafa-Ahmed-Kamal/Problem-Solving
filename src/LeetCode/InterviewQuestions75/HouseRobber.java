package LeetCode.InterviewQuestions75;

public class HouseRobber {
    private int memoaization[];
    public int rob(int[] nums) {
        memoaization = new int[nums.length];
        return robRecursive(nums, 0);
    }

    public int robRecursive(int[] nums, int start){
        if(start>=nums.length)return 0;
        if(memoaization[start]!=0)return memoaization[start];
        memoaization[start] = (nums[start]==0)? robRecursive(nums,start+1) : Math.max(nums[start] + robRecursive(nums, start+2), robRecursive(nums,start+1));
        return memoaization[start];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int nums[] = {2,7,9,3,1};
        System.out.println(hr.rob(nums));
    }
}
