package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class DecodeWays {

    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        dp[s.length()] = 1;
        dp[s.length()-1] = s.charAt(s.length()-1)=='0'? 0:1;
        for (int i = s.length()-2; i >=0 ; i--) {
            if(s.charAt(i)=='0'){
                dp[i] = 0;
            }
            else if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                dp[i] = dp[i+1] + dp[i+2];
            }
            else{
                dp[i] = dp[i+1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];

    }

    public static void main(String[] args) {
        DecodeWays dc = new DecodeWays();
        String s = "2611055971756562";
        System.out.println(dc.numDecodings(s));
    }
}
