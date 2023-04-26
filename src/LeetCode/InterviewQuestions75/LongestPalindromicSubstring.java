package LeetCode.InterviewQuestions75;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPalindromicSubstring {
    int memoaizaton[][];
    int maxLength,maxStart,maxEnd;
    public String longestPalindrome(String s) {
        maxLength=0;maxStart=0;maxEnd=0;
        memoaizaton = new int[s.length()][s.length()];
        char sArr[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                traverseMemoaization(memoaizaton,i,j,sArr);
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
    private int traverseMemoaization(int[][] memoaizaton, int start, int end, char[] s){
        if(start>=end)return 1;
        if(start==s.length-1 || end==0 || memoaizaton[start][end]!=0)return memoaizaton[start][end];
        memoaizaton[start][end] = s[start]==s[end]?traverseMemoaization(memoaizaton,start+1,end-1,s):-1;
        if(memoaizaton[start][end]==1 && maxLength<end-start+1){
            maxLength = end-start+1;
            maxStart = start;
            maxEnd = end;
        }
        return memoaizaton[start][end];
    }
//    int maxLength;
//    int maxStart, maxEnd;
    public String betterSolution(String s){
        maxLength = 0;maxStart=0;maxEnd=0;
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(i,i,s);
            expandAroundCenter(i,i+1,s);
        }
        return s.substring(maxStart,maxEnd);
    }
    public void expandAroundCenter(int start, int end, String s){
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        if(maxLength<end-start+1){
            maxLength = end-start+1;
            maxStart = start+1;
            maxEnd = end;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.betterSolution("a"));
    }
}
