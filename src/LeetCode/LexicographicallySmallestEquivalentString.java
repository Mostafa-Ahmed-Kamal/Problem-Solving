package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LexicographicallySmallestEquivalentString {
    int[] characters;
    private int find(char c){
        int cIndex = c-'a';
        while(characters[cIndex]!=cIndex){ // a self loop represents the root node
            cIndex = characters[cIndex];
        }
        return cIndex;
    }
    private void union(char c1, char c2){
        int c1Index = find(c1);
        int c2Index = find(c2);
        int newRoot = Math.min(c1Index,c2Index);
        characters[c1Index] = characters[c2Index] =  newRoot;
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        characters = new int[26];
        for (int i = 0; i < 26; i++) {
            characters[i] = i;
        }
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            union(s1.charAt(i),s2.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()){
            char smallestEquivalentCharacter = (char)(find(c)+'a');
            result.append(smallestEquivalentCharacter);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString ls =new LexicographicallySmallestEquivalentString();
        String s1 = "leetcode" ,s2 = "programs" ,baseStr = "sourcecode";
        System.out.println(ls.smallestEquivalentString(s1,s2,baseStr));
    }
}
