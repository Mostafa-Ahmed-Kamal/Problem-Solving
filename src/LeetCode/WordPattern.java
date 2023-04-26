package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length())return false;
        HashMap<String,Character> wordMatch = new HashMap<>();
        HashMap<Character,String> patternMatch = new HashMap<>();
        for (int i=0 ; i<pattern.length(); i++){
            char letter = pattern.charAt(i);
            String word = words[i];
            if(!wordMatch.containsKey(word)){
                wordMatch.put(word,letter);
            }
            if(!patternMatch.containsKey(letter)){
                patternMatch.put(letter,word);
            }
            if(!wordMatch.get(word).equals(letter) || !patternMatch.get(letter).equals(word)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
//        String pattern = "aaaa", s = "dog cat cat dog";
        String pattern = "abba", s = "dog dog dog dog";
        System.out.println(wp.wordPattern(pattern,s));
    }
}
