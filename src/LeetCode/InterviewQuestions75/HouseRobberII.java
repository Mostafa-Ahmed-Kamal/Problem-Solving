package LeetCode.InterviewQuestions75;

public class HouseRobberII {

    private int memoaization[][];
    public int rob(int[] nums) {
        memoaization = new int[nums.length][2];
        return Math.max(robRecursive(nums, 1,0), nums[0] + robRecursive(nums,2, 1));
    }

    public int robRecursive(int[] nums, int start, int end){
        if(start>=nums.length-end) return 0;
        if(memoaization[start][end]!=0)return memoaization[start][end];
        memoaization[start][end] = (nums[start]==0)? robRecursive(nums,start+1,end) : Math.max(nums[start] + robRecursive(nums, start+2,end), robRecursive(nums,start+1,end));
        return memoaization[start][end];
    }

    public static void main(String[] args) {
        HouseRobberII hr = new HouseRobberII();
        int nums[] = {2,7,9,3,1};
        System.out.println(hr.rob(nums));
    }

}
