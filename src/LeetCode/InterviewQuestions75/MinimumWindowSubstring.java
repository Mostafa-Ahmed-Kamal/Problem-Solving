package LeetCode.InterviewQuestions75;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> neededMap = new HashMap<>();
        HashMap<Character,Integer> haveMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int MinStart=0, MinEnd=0;
        int currStart=0, currEnd=0;
        for (char c : t.toCharArray()){
            neededMap.put(c,neededMap.getOrDefault(c,0)+1);
            haveMap.putIfAbsent(c,0);
        }
        int haveSize=0, neededSize=neededMap.size();
        for (; currEnd<s.length(); currEnd++){
            char c = s.charAt(currEnd);
            if(neededMap.containsKey(c)){
                int haveMapValue = haveMap.getOrDefault(c,0)+1;
                haveMap.put(c,haveMapValue);
                if(neededMap.get(c)==haveMapValue) {
                    haveSize++;
                }
                if(haveSize==neededSize){
                    for (; currStart < currEnd; currStart++) {
                        char c1 = s.charAt(currStart);
                        if(haveMap.containsKey(c1)){
                            haveMap.put(c1,haveMap.get(c1)-1);
                            if (haveMap.get(c1)<neededMap.get(c1)) {
                                haveSize--;
                                break;
                            }
                        }
                    }
                    if(currEnd - currStart+1 < minLength){
                        minLength = currEnd - currStart+1;
                        MinEnd = currEnd+1;
                        MinStart = currStart;
                    }
                    currStart++;
                }
            }
        }
        return s.substring(MinStart,MinEnd);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring ms = new MinimumWindowSubstring();
        String s = "aaaaaaaaaaaabbbbbcdd", t = "abcdd";
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String s2 = "a", t2 = "b";
        System.out.println(ms.minWindow(s,t));
        System.out.println(ms.minWindow(s1,t1));
        System.out.println(ms.minWindow(s2,t2));
    }
}
