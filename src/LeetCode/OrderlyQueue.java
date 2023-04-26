package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string..
 *
 * Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "cba", k = 1
 * Output: "acb"
 * Explanation:
 * In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
 * In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".
 * Example 2:
 *
 * Input: s = "baaca", k = 3
 * Output: "aaabc"
 * Explanation:
 * In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
 * In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".
 */

public class OrderlyQueue {

    public String orderlyQueue(String s, int k) {
        if(k>1) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
        String smallestLexicographicalString = s;
        for (int i = 0; i < s.length(); i++) {
            String potentialS = s.substring(i)+s.substring(0,i);
            if(potentialS.compareTo(smallestLexicographicalString)<0)
                smallestLexicographicalString = potentialS;
        }
        return smallestLexicographicalString;
    }

    public static void main(String[] args) {
        OrderlyQueue oq = new OrderlyQueue();
        String s = "xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq";
        int k = 1;
        System.out.println(oq.orderlyQueue(s,k));
    }
}
