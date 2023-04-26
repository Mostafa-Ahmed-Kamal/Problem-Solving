package LeetCode;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    public int maximumGain(String s, int x, int y) {
        char bestC1 = x > y ? 'a' : 'b', bestC2 = x > y ? 'b' : 'a';
        int maxValue = Math.max(x, y), minValue = Math.min(x, y);
        int c1Count=0,c2Count=0;
        int maxGain = 0;
        for (char c : s.toCharArray()) {
            if(c==bestC2){
                if(c1Count>0){
                    c1Count--;
                    maxGain+=maxValue;
                }
                else {
                    c2Count++;
                }
            }
            else if(c==bestC1){
                c1Count++;
            }
            else{ // if the character is not a nor b we disconnect the previous string from the new one and restart
                maxGain += Math.min(c1Count,c2Count)*minValue;
                c1Count=0;c2Count=0;
            }
        }
        maxGain += Math.min(c1Count,c2Count)*minValue;
        return maxGain;
    }
    public static void main(String[] args) {
        MaximumScoreFromRemovingSubstrings msf = new MaximumScoreFromRemovingSubstrings();
        String s = "aabbaaxybbaabb";
        int x = 5, y = 4;
        System.out.println(msf.maximumGain(s,x,y));
    }
}
