package LeetCode;

public class StoneGameIII {
    int[] dp;
    boolean[][] visited;
    public String stoneGameIII(int[] stoneValue) {
        dp = new int[stoneValue.length];
        visited = new boolean[2][stoneValue.length];
        int winner = optimalPlay(0,stoneValue,0);
        if (winner==0)return "Tie";
        return winner>0?"Alice":"Bob";
    }
    public int optimalPlay(int turn, int[] stoneValue, int currentStonePile){
        if (currentStonePile>=stoneValue.length)return 0;
        if (visited[turn][currentStonePile])return dp[currentStonePile];
        int takeLimit = Math.min(currentStonePile+3,stoneValue.length);
        int totalPoints = 0;
        int bestScore = Integer.MIN_VALUE;
        for (int i = currentStonePile; i < takeLimit; i++) {
            totalPoints+=stoneValue[i];
            int optimalPlayScore = totalPoints - optimalPlay(turn,stoneValue,i+1);
            bestScore = Math.max(bestScore,optimalPlayScore);
        }
        dp[currentStonePile] = bestScore;
        return bestScore;
    }

    public static void main(String[] args) {
        StoneGameIII stoneGameIII = new StoneGameIII();
        int[] values = {1,2,3,6};
        System.out.println(stoneGameIII.stoneGameIII(values));
    }
}
