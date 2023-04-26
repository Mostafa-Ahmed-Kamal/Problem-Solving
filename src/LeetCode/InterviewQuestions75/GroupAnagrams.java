package LeetCode.InterviewQuestions75;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String str: strs){
            int frequencies[] = new int[26];
            for (char c: str.toCharArray()){
                frequencies[c-'a']++;
            }
            if(map.containsKey(Arrays.hashCode(frequencies))){
                map.get(Arrays.hashCode(frequencies)).add(str);
            }
            else{
                LinkedList<String> list = new LinkedList<>();
                list.add(str);
                map.put(Arrays.hashCode(frequencies),list);
            }
        }
        return new LinkedList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String strs[] = {"bdca","abcd","aaaa"};
        System.out.println(ga.groupAnagrams(strs));
    }
}
