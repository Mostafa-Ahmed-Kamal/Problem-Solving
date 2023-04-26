package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    HashSet<Character> vowels;
    public int maxVowels(String s, int k) {
        vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int vowelsCount = 0;
        for(int i=0; i<k && i<s.length(); i++){
            if (vowels.contains(s.charAt(i)))vowelsCount++;
        }
        int maxVowelsCount = vowelsCount;
        for (int i = k; i < s.length(); i++) {
            vowelsCount+= vowels.contains(s.charAt(i))?1:0;
            vowelsCount-= vowels.contains(s.charAt(i-k))?1:0;
            maxVowelsCount = Math.max(maxVowelsCount,vowelsCount);
        }
        return maxVowelsCount;
    }
}
