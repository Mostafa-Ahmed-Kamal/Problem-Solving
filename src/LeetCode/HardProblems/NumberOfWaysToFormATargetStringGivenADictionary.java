package LeetCode.HardProblems;

import java.util.Arrays;

public class NumberOfWaysToFormATargetStringGivenADictionary {
    int[][] characterCount;
    final long MOD= 1000000007;
    int[][] memo;
    public int numWays(String[] words, String target) {
        int k = words[0].length();
        characterCount = new int[k][26];
        memo = new int[k][target.length()];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < k; j++) {
                characterCount[j][words[i].charAt(j)-'a']++;
            }
        }
        return dp(0,0,target);
    }
    private int dp(int k, int targetIndex, String target){
        if (characterCount.length-k<target.length()-targetIndex)return 0;
        if (targetIndex>=target.length())return 1;
        if (memo[k][targetIndex]!=0)return memo[k][targetIndex];
        long count = 0;
        for (int i = k; i < characterCount.length; i++) {
            if (characterCount[i][target.charAt(targetIndex)-'a']==0)continue;
            count = (count+ (long)characterCount[i][target.charAt(targetIndex)-'a']*(long)(dp(i+1,targetIndex+1,target)))%MOD;
        }
        memo[k][targetIndex] = (int) (count%MOD);
        return memo[k][targetIndex];
    }

    public static void main(String[] args) {
        NumberOfWaysToFormATargetStringGivenADictionary nw = new NumberOfWaysToFormATargetStringGivenADictionary();
        String words[] = {"acca","bbbb","caca"}, target = "aba";
        System.out.println(nw.numWays(words,target));
    }
}
