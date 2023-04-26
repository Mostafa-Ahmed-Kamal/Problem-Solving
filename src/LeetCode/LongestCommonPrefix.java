package LeetCode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder lcp = new StringBuilder(strs[0]);
        int minString;
        for (String word:strs) {
            if(lcp.isEmpty())break;
            minString = Math.min(lcp.length(),word.length());
            if(minString<lcp.length())lcp.delete(minString,lcp.length());
            for (int i = 0; i < minString; i++) {
                if(lcp.charAt(i)!=word.charAt(i)){
                    lcp.delete(i,lcp.length());
                    break;
                }
            }
        }
        return lcp.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"dog","racecar","car"};
        System.out.println(lcp.longestCommonPrefix(strs));
        // Output = ""

        strs = new String[]{"flower","flow","flight"};
        System.out.println(lcp.longestCommonPrefix(strs));
        // Output = "fl"

        strs = new String[]{"ab","a"};
        System.out.println(lcp.longestCommonPrefix(strs));
        // Output = "a"
    }
}
