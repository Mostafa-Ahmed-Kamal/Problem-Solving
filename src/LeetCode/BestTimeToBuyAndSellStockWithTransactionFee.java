package LeetCode;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    int[][] dp;
    boolean[][] visitedStrategy;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        visitedStrategy = new boolean[prices.length][2];
        return dp(prices,fee,0,true);
    }
    private int dp(int[] prices, int fee, int day, boolean canBuy){
        if (day>=prices.length)return 0;
        int buySell = canBuy?0:1;
        if (visitedStrategy[day][buySell])return dp[day][buySell];
        int bestStrategy = canBuy? Math.max(dp(prices,fee,day+1, false)-fee-prices[day], dp(prices,fee,day+1, true)):
                Math.max(dp(prices,fee,day+1,true)+prices[day],dp(prices,fee,day+1,false));
        dp[day][buySell] = bestStrategy;
        visitedStrategy[day][buySell] = true;
        return bestStrategy;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee bfe = new BestTimeToBuyAndSellStockWithTransactionFee();
        int prices[] = {1,3,2,8,4,9}, fee = 2;
        System.out.println(bfe.maxProfit(prices,fee));
    }
}
