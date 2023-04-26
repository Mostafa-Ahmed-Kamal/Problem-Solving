package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()];
        Arrays.fill(dp, Boolean.TRUE);
        return wordBreakRecursive(s, wordDict, dp);
    }

    public boolean wordBreakRecursive(String s, List<String> wordDict, boolean[] dp) {
        if(s.length()==0)return true;
        if(dp[s.length()-1] ==  false) return false;
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if(s.startsWith(word) && wordBreakRecursive(s.replaceFirst(word,""), wordDict, dp)) return true;
        }
        dp[s.length()-1] = false;
        return false;
    }

    public boolean bottomUpApproach(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;
        for (int i = s.length()-1; i>=0 ; i--) {
            for (String word: wordDict){
                if(s.substring(i).startsWith(word) && dp[i+word.length()]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }


        public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "abcd";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("a");
        wordDict.add("abc");
        wordDict.add("b");
        wordDict.add("cd");
            System.out.println(wb.wordBreak(s, wordDict));
            System.out.println(wb.bottomUpApproach(s, wordDict));
    }
}
