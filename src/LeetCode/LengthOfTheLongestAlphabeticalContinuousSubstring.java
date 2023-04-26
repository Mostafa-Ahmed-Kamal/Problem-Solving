package LeetCode;

public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public int longestContinuousSubstring(String s) {
        int start=0;
        int maxLength=1;
        for (int end = 1; end < s.length(); end++) {
            if (end-start!=s.charAt(end)-s.charAt(start)){
                maxLength = Math.max(maxLength,end-start);
                start=end;
            }
        }
        return Math.max(maxLength,s.length()-start);
    }

    public static void main(String[] args) {
        LengthOfTheLongestAlphabeticalContinuousSubstring l = new LengthOfTheLongestAlphabeticalContinuousSubstring();
        String s = "abcde";
        System.out.println(l.longestContinuousSubstring(s));
    }
}
