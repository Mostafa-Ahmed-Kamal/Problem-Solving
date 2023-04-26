package LeetCode;

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        int[] word1CharacterCount = new int[26];
        int[] word2CharacterCount = new int[26];
        HashSet<Character> word1Characters = new HashSet<>();
        HashSet<Character> word2Characters = new HashSet<>();
        int wordsLength = word1.length();
        for (int i = 0; i < wordsLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            word1CharacterCount[c1-'a']++;
            word2CharacterCount[c2-'a']++;
            word1Characters.add(c1);
            word2Characters.add(c2);
        }
        if(!word1Characters.equals(word2Characters))return false;
        Arrays.sort(word1CharacterCount);
        Arrays.sort(word2CharacterCount);
        return Arrays.equals(word1CharacterCount, word2CharacterCount);
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose d = new DetermineIfTwoStringsAreClose();
        String word1 = "aba";
        String word2 = "baa";
        System.out.println(d.closeStrings(word1,word2));
    }
}
