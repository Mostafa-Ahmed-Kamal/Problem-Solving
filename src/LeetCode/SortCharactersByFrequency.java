package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        StringBuilder[] charactersFrequency = new StringBuilder[62];
        for (int i = 0; i < charactersFrequency.length; i++) {
            charactersFrequency[i] = new StringBuilder();
        }
        for (char c:s.toCharArray()){
            if(c>='a' && c<='z'){
                charactersFrequency[c-'a'+26].append(c);
            }
            else if(c>='A' && c<='Z'){
                charactersFrequency[c-'A'].append(c);
            }
            else if(c>='0' && c<='9'){
                charactersFrequency[c-'0' + 52].append(c);
            }
        }
        Arrays.sort(charactersFrequency, Comparator.comparingInt(i -> i.length()));
        StringBuilder result = new StringBuilder();
        for (int i = charactersFrequency.length-1; i >= 0 ; i--) {
            if(charactersFrequency[i].length()==0)break;
            result.append(charactersFrequency[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sc = new SortCharactersByFrequency();
        String s = "aa13434bbc";
        System.out.println(sc.frequencySort(s));
    }
}
