package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class SortThePeople {
    public String[] sortPeople(String[] names, int[] heights){
        HashMap<Integer,String> map = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            map.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        for (int i = n-1; i >= 0; i--) {
            names[i] = map.get(heights[n-1-i]);
        }
        return names;
    }

    public static void main(String[] args) {
        SortThePeople sp = new SortThePeople();
        String names[] = {"Mary", "John","Emma"};
        int heights[] = {180,165,170};
        System.out.println(Arrays.toString(sp.sortPeople(names,heights)));
    }
}
