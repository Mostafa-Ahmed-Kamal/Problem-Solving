package LeetCode.HardProblems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EditDistance {
    int[][] memoaization;
    public int minDistance(String word1, String word2) {
        memoaization = new int[word1.length()][word2.length()];
//        return topDownApproach(word1,word2,0,0);
        return bottomUpApproach(word1,word2);
    }
    private int topDownApproach(String word1, String word2, int index1, int index2){
        if(index1>=word1.length())return word2.length()-index2;
        if(index2>=word2.length())return word1.length()-index1;
        if(memoaization[index1][index2]!=0)return memoaization[index1][index2];
        if(word1.charAt(index1)==word2.charAt(index2)){
            memoaization[index1][index2] = topDownApproach(word1,word2,index1+1,index2+1);
        }
        else{
            int AddOrDelete = Math.min(topDownApproach(word1,word2,index1+1,index2),topDownApproach(word1,word2,index1,index2+1));
            int orReplace = Math.min(AddOrDelete,topDownApproach(word1,word2,index1+1,index2+1));
            memoaization[index1][index2] = 1 + orReplace;
        }
        return memoaization[index1][index2];
    }
    private int bottomUpApproach(String word1, String word2){
        int n = word1.length()+1;
        int m = word2.length()+1;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][m-1] = n-i-1;
        }
        for (int i = 0; i < m; i++) {
            dp[n-1][i] = m-i-1;
        }
        for (int i = n-2; i >= 0 ; i--) {
            for (int j = m-2; j >= 0 ; j--) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    dp[i][j] = 1+Math.min(dp[i+1][j+1],Math.min(dp[i][j+1],dp[i+1][j]));
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        String word1 = "horse", word2 = "ros";
        System.out.println(ed.minDistance(word1,word2));
    }
}
;