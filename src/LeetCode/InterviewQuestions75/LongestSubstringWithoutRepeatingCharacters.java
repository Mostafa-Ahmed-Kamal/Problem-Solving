package LeetCode.InterviewQuestions75;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int count=0,maxCount=0;
        int index, startIndex=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i))<startIndex){
                count++;
            }
            else{
                index = map.get(s.charAt(i));
                count = i-index;
                startIndex = index+1;
            }
            maxCount = Math.max(maxCount,count);
            map.put(s.charAt(i),i);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        String s = "blqsearxxxbiwqa";
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
