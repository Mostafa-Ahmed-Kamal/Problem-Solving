package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int n) {
        if(n==0) return new int[] {0};
        if(n==1) return new int[] {0,1};
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        int currentNOfBits = 1;
        int backReferenceIndex = 0;
        int remainingValuesForNewSetOfBits = (int)Math.pow(2,currentNOfBits);
        for (int i = 2; i < result.length; i++) {
            if(remainingValuesForNewSetOfBits==0){
                backReferenceIndex = 0;
                currentNOfBits++;
                remainingValuesForNewSetOfBits = (int)Math.pow(2,currentNOfBits);
            }
            result[i] = result[backReferenceIndex]+1;
            backReferenceIndex++;
            remainingValuesForNewSetOfBits--;
        }
        return result;
    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        System.out.println(Arrays.toString(cb.countBits(5)));
    }
}
