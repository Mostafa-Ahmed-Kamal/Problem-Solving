package LeetCode;

import java.util.HashMap;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int[] s1CharacterCount = new int[26];
        for (char c:s1.toCharArray()){
            s1CharacterCount[c-'a']++;
        }
        int start=-1, end=0;
        while(end<s2.length()){
            if(end-start-1 == s1Length)return true;
            int characterValue = s2.charAt(end)-'a';
            if(s1CharacterCount[characterValue]<=0){
                while(start<end && s1CharacterCount[characterValue]<=0){
                    start++;
                    int startCharacterValue = s2.charAt(start)-'a';
                    s1CharacterCount[startCharacterValue]++;
                }
            }
            s1CharacterCount[characterValue]--;
            end++;
        }
        return end-start-1==s1Length;
    }

    public static void main(String[] args) {
        PermutationInString ps = new PermutationInString();
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(ps.checkInclusion(s1,s2));
    }
}
