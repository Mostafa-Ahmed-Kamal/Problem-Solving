package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        int[] characterCount = new int[26];
        List<Integer> result = new LinkedList<>();
        int start=0, end=0;
        for (char c:p.toCharArray()){
            characterCount[c-'a']++;
        }
        while(end<s.length()){
            if(end-start==p.length())
                result.add(start);
            char c = s.charAt(end);
            if(characterCount[c-'a']<=0){
                while(start<end && characterCount[c-'a']<=0){
                    characterCount[s.charAt(start)-'a']++;
                    start++;
                }
            }
            if(characterCount[c-'a']>0){
                characterCount[c-'a']--;
            }
            else{
                start++;
            }
            end++;
        }
        if(end-start==p.length())result.add(start);
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString fa = new FindAllAnagramsInAString();
        String s = "cbaebabacd", p = "abc";
        System.out.println(fa.findAnagrams(s,p));
    }
}
