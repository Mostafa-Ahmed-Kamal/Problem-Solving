package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class BestTimeToBuyAndSellStockWithCooldown {
    private enum stockerState{
        Buy,
        Sell
    }
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j]=-1;
            }
        }
        return maxProfitRecursive(prices,stockerState.Buy,0);
    }
    private int maxProfitRecursive(int[] price, stockerState state, int dayID){
        if(dayID>=price.length) return 0;
        int stateID = state==stockerState.Buy?0:1;
        if(dp[dayID][stateID]!=-1)return dp[dayID][stateID];
        // we can either buy or do nothing
        int idleDay = maxProfitRecursive(price,state,dayID+1);
        int activeDay = state==stockerState.Buy? maxProfitRecursive(price,stockerState.Sell,dayID+1)-price[dayID]:
                                                 maxProfitRecursive(price,stockerState.Buy,dayID+2)+price[dayID];
        dp[dayID][stateID] = Math.max(idleDay,activeDay);
        return dp[dayID][stateID];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown bt = new BestTimeToBuyAndSellStockWithCooldown();
        int[] prices = {1,2,3,0,2};
        System.out.println(bt.maxProfit(prices));

    }
}
