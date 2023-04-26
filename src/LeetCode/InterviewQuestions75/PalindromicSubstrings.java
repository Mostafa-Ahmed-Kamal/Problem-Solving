package LeetCode.InterviewQuestions75;

public class PalindromicSubstrings {
    public int countSubstrings(String s){
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            count+=expandAroundCenter(i,i,s);
            count+=expandAroundCenter(i,i+1,s);
        }
        return count;
    }
    public int expandAroundCenter(int start, int end, String s){
        int count=0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings pss = new PalindromicSubstrings();
        String s = "abbba";
        System.out.println(pss.countSubstrings(s));
    }
}
