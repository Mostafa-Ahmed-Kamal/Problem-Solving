package LeetCode.InterviewQuestions75;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int charFrequency[] = new int[26];
        int maxFrequency = 1;
        int windowStart=0, windowEnd=0;
        int maxCount = 0;
        boolean isValid;
        for (char c:s.toCharArray()){
            int frequency = ++charFrequency[c-'A'];
            if(frequency>maxFrequency){
                maxFrequency = frequency;
            }
            isValid = (windowEnd-windowStart+1)-maxFrequency<=k;
            if(!isValid) {
                char removedChar = s.charAt(windowStart);
                charFrequency[removedChar-'A']-=1;
                windowStart++;
            }
            maxCount = Math.max(maxCount, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lr = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(lr.characterReplacement(s,k));
    }
}
