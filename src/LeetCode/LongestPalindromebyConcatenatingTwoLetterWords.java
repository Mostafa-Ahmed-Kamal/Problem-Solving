package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/***
 * You are given an array of strings words. Each element of words consists of two lowercase English letters.
 *
 * Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
 *
 * Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["lc","cl","gg"]
 * Output: 6
 * Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
 * Note that "clgglc" is another longest palindrome that can be created.
 * Example 2:
 *
 * Input: words = ["ab","ty","yt","lc","cl","ab"]
 * Output: 8
 * Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
 * Note that "lcyttycl" is another longest palindrome that can be created.
 * Example 3:
 *
 * Input: words = ["cc","ll","xx"]
 * Output: 2
 * Explanation: One longest palindrome is "cc", of length 2.
 * Note that "ll" is another longest palindrome that can be created, and so is "xx".
 */
public class LongestPalindromebyConcatenatingTwoLetterWords {

    public int longestPalindrome(String[] words) {
        int count = 0;
        HashMap<String,Integer> match = new HashMap<>();
        int symmetricElements = 0;
        int value;
        for (String word:words){
            value = match.getOrDefault(word,-1);
            if(value>0){
                if(word.charAt(0)==word.charAt(1))symmetricElements--;
                count+=4;
                match.replace(word,value-1);
            }
            else {
                if(word.charAt(0)==word.charAt(1)){
                    symmetricElements++;
                }
                //append the reverse of the string to the hashset
                String temp = ""+word.charAt(1)+word.charAt(0);
                int tempValue = match.getOrDefault(temp,0);
                if(tempValue>0)match.put(temp,tempValue+1);
                else match.put(temp,1);
            }
        }
        if(symmetricElements>0)count+=2;
        return count;
    }

    public static void main(String[] args) {
        LongestPalindromebyConcatenatingTwoLetterWords lpw = new LongestPalindromebyConcatenatingTwoLetterWords();
        String[] input;
        input = new String[] {"cc","ll","xx"};
        System.out.println(lpw.longestPalindrome(input));

        input = new String[] {"ab","ty","yt","lc","cl","ab"};
        System.out.println(lpw.longestPalindrome(input));

        input = new String[] {"lc","cl","gg"};
        System.out.println(lpw.longestPalindrome(input));

        input = new String[]  {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
        System.out.println(lpw.longestPalindrome(input));
    }
}
