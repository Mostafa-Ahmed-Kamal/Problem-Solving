package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        if (s.length()!=goal.length())return false;
        boolean containsDuplicate = false;
        List<Integer> incorrectLetters = new LinkedList<>();
        HashSet<Character> characterSet = new HashSet<>();
        for (int i=0; i<s.length(); i++){
            if (characterSet.contains(s.charAt(i)))containsDuplicate = true;
            characterSet.add(s.charAt(i));
            if (s.charAt(i)!=goal.charAt(i)){
                incorrectLetters.add(i);
            }
        }
        if (incorrectLetters.size()==0 && containsDuplicate)return true;
        if (incorrectLetters.size() != 2)return false;
        return (s.charAt(incorrectLetters.get(0))==goal.charAt(incorrectLetters.get(1)) && s.charAt(incorrectLetters.get(1))==goal.charAt(incorrectLetters.get(0)));
    }

    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        String s = "abac", goal = "abad";
        System.out.println(bs.buddyStrings(s,goal));
    }
}
