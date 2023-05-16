package LeetCode;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        for (int i = questions.length-1; i >= 0 ; i--) {
            long nextMaxScore = (i+1+questions[i][1]>questions.length)?0:dp[i+1+questions[i][1]];
            dp[i] = Math.max(dp[i+1],questions[i][0]+nextMaxScore);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower sb = new SolvingQuestionsWithBrainpower();
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(sb.mostPoints(questions));
    }
}
