package LeetCode;

public class MaximizeTheConfusionOfAnExam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int trueCount=0,falseCount=0;
        int start=0;
        int maxLength = 0;
        for (int end = 0; end < answerKey.length(); end++) {
            if (answerKey.charAt(end)=='T'){
                trueCount++;
            }
            else{
                falseCount++;
            }
            int minCount = Math.min(trueCount,falseCount);
            while(minCount>k){
                if (answerKey.charAt(start)=='T'){
                    trueCount--;
                }
                else{
                    falseCount--;
                }
                minCount = Math.min(trueCount,falseCount);
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MaximizeTheConfusionOfAnExam me = new MaximizeTheConfusionOfAnExam();
        String answerKey = "TTFTTFTT";
        int k = 1;
        System.out.println(me.maxConsecutiveAnswers(answerKey,k));
    }
}
