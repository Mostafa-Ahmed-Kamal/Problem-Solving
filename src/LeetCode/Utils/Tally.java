package LeetCode.Utils;

import java.util.HashMap;

public class Tally {
    public static HashMap<Integer,Integer> tallyOfAnIntegerArray(int[] arr){
        HashMap<Integer,Integer> result = new HashMap<>();
        for (int num : arr){
            result.put(num, result.getOrDefault(num,0)+1);
        }
        return result;
    }
}
