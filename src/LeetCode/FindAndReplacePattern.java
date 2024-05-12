package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words){
            if(matchesPattern(word, pattern)) result.add(word);
        }
        return result;
    }

    private boolean matchesPattern(String word, String pattern){
        if (word.length() != pattern.length()) return false;
        HashMap<Character,Character> wordToPattern = new HashMap<>();
        HashSet<Character> reservedCharacters = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (!wordToPattern.containsKey(word.charAt(i))) {
                if(reservedCharacters.contains(pattern.charAt(i))) return false;
                wordToPattern.put(word.charAt(i),pattern.charAt(i));
                reservedCharacters.add(pattern.charAt(i));
            }
            else if (wordToPattern.get(word.charAt(i))!=pattern.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindAndReplacePattern frp = new FindAndReplacePattern();
        System.out.println(frp.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
