package LeetCode;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    HashMap<Character,Integer> dictionary;
    public boolean isAlienSorted(String[] words, String order) {
        dictionary = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            dictionary.put(order.charAt(i),i);
        }
        for (int i = 1; i < words.length; i++) {
            if(!correctlyOrdered(words[i-1],words[i]))return false;
        }
        return true;
    }
    private boolean correctlyOrdered(String smaller, String larger){
        int index=0;
        while(index<smaller.length() && index<larger.length()){
            if(smaller.charAt(index)==larger.charAt(index))
                index++;
            else{
                return dictionary.get(smaller.charAt(index))<dictionary.get(larger.charAt(index));
            }
        }
        return larger.length()>=smaller.length();
    }

    public static void main(String[] args) {
        VerifyingAnAlienDictionary vad = new VerifyingAnAlienDictionary();
        String words[] = {"hello","leetcode"}, order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(vad.isAlienSorted(words,order));
    }
}
