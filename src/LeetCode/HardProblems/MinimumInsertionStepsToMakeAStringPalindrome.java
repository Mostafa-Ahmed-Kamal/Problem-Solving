package LeetCode.HardProblems;

public class MinimumInsertionStepsToMakeAStringPalindrome {
    int[][] dp;
    public int minInsertions(String s) {
        dp = new int[s.length()][s.length()];
        return minInsertions(s,0,s.length()-1);
    }
    private int minInsertions(String s, int start, int end){
        if (start>=end)return 0;
        if (dp[start][end]!=0)return dp[start][end];
        int newStart=start, newEnd = end;
        while(newStart<newEnd && s.charAt(newStart)==s.charAt(newEnd)){
            newStart++;
            newEnd--;
        }
        dp[start][end] = (newStart>=newEnd)?0:1+Math.min(minInsertions(s,newStart+1,newEnd),minInsertions(s,newStart,newEnd-1));
        return dp[start][end];
    }

    public static void main(String[] args) {
        MinimumInsertionStepsToMakeAStringPalindrome mi = new MinimumInsertionStepsToMakeAStringPalindrome();
        String s = "leetcode";
        System.out.println(mi.minInsertions(s));
    }
}
