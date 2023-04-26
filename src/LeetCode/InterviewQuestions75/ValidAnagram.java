package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char arrS[] = s.toCharArray();
        char arrT[] = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        return Arrays.equals(arrS,arrT);
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "abba";
        String t = "bbaa";
        System.out.println(va.isAnagram(s,t));
    }
}
