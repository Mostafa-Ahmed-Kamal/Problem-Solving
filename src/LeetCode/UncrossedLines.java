package LeetCode;

public class UncrossedLines {
    int[][] memo;
    boolean[][] visited;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        visited = new boolean[nums1.length][nums2.length];
        return maxUncrossedLines(nums1,nums2,0,0);
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2, int nums1Index, int nums2Index){
        if (nums1Index>=nums1.length || nums2Index>=nums2.length)return 0;
        if (visited[nums1Index][nums2Index])return memo[nums1Index][nums2Index];
        visited[nums1Index][nums2Index] = true;
        memo[nums1Index][nums2Index] =
                (nums1[nums1Index]==nums2[nums2Index])?
                        1+maxUncrossedLines(nums1,nums2,nums1Index+1,nums2Index+1):
        Math.max(maxUncrossedLines(nums1,nums2,nums1Index+1,nums2Index),maxUncrossedLines(nums1,nums2,nums1Index,nums2Index+1));
        return memo[nums1Index][nums2Index];
    }
    private int iterativeApproach(int[] nums1, int[] nums2){
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i < nums1.length+1; i++) {
            for (int j = 1; j < nums2.length+1; j++) {
                dp[i][j] = (nums1[i-1]==nums2[j-1])? 1+dp[i-1][j-1]:Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[nums1.length][nums2.length];
    }

    public static void main(String[] args) {
        UncrossedLines ul = new UncrossedLines();
        int[] nums1 = {2,5,1,2,5}, nums2 = {10,5,2,1,5,2};
        System.out.println(ul.maxUncrossedLines(nums1,nums2));
        System.out.println(ul.iterativeApproach(nums1,nums2));
    }
}
