package LeetCode;

import java.util.*;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        if(s.length()%2!=0)return false;
        char[] arr = s.toCharArray();
        int n = s.length()/2;
        int vowelsCountRHS = 0 ;
        int vowelsCountLFS = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("start: " + arr[i] + " end: " + arr[i+n]);
            if(vowels.contains(arr[i]))vowelsCountLFS++;
            if(vowels.contains(arr[i+n]))vowelsCountRHS++;
        }
        return vowelsCountLFS == vowelsCountRHS;
    }

    public static void main(String[] args) {
        DetermineIfStringHalvesAreAlike d = new DetermineIfStringHalvesAreAlike();
        System.out.println(d.halvesAreAlike("textbook"));
    }
}
