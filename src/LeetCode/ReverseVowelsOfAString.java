package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char newS[] = s.toCharArray();
        int start=0, end=s.length()-1;
        while(start<end){
            if(vowels.contains(newS[start]) && vowels.contains(newS[end])){
                char temp = newS[start];
                newS[start] = newS[end];
                newS[end] = temp;
                start++;
                end--;
            }
            start = vowels.contains(newS[start])? start:start+1;
            end = vowels.contains(newS[end])? end:end-1;
        }
        return String.valueOf(newS);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString rv = new ReverseVowelsOfAString();
        String s = "leetcode";
        System.out.println(rv.reverseVowels(s));
    }
}
