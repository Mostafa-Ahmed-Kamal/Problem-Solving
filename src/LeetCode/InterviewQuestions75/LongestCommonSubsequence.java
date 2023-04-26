package LeetCode.InterviewQuestions75;

import LeetCode.LongestCommonPrefix;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        LCSRecursive(text1, text2, 0, 0, dp);
        return dp[0][0];
    }

    public void LCSRecursive(String text1, String text2, int end1, int end2, int[][] dp){
        if(end1>=text1.length() || end2>=text2.length() || dp[end1][end2]!=0) return;
        if(text1.charAt(end1)==text2.charAt(end2)){
            LCSRecursive(text1,text2,end1+1, end2+1, dp);
            dp[end1][end2] = 1 + dp[end1+1][end2+1];
        }
        else{
            LCSRecursive(text1,text2,end1+1, end2, dp);
            LCSRecursive(text1,text2,end1, end2+1, dp);
            dp[end1][end2] = Math.max(dp[end1+1][end2], dp[end1][end2+1]);
        }
    }

    public int betterSolution(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for (int i = text1.length()-1; i >=0 ; i--) {
            for (int j = text2.length()-1; j >=0 ; j--) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = 1+ dp[i+1][j+1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abc";
        String text2 = "def";
        text1 = "abcde";
        text2 = "ace";
        System.out.println(lcs.longestCommonSubsequence(text1,text2));
        System.out.println(lcs.betterSolution(text1,text2));
    }
}