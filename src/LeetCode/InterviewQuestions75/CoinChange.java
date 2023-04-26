package LeetCode.InterviewQuestions75;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i]=amount+1;//the max possible number is amount when the coin is a 1
        }
        dp[0]=0;
        for (int i = 1; i < amount+1; i++) {
            for(int coin:coins){
                if(i-coin>=0) dp[i]=Math.min(dp[i],1+dp[i-coin]);
                else break;
            }
        }
        return dp[amount]==amount+1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int coins[] = {2,5,10};
        System.out.println(cc.coinChange(coins,17));
    }

}
