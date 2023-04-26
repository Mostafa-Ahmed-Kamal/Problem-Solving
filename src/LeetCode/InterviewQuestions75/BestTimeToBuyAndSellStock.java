package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxFuture[] = new int[prices.length];
        int max = 0;
        for (int i = prices.length-1; i>=0 ; i--) {
            max = Math.max(max,prices[i]);
            maxFuture[i] = max;
        }
        max = 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,maxFuture[i]-prices[i]);
        }
        return max;
    }
    public int betterSolution(int[] prices){
        if (prices.length<2) return 0;
        int max=0, buyPointer=0, sellPointer=1;
        while(sellPointer<prices.length){
            if (prices[buyPointer]>prices[sellPointer]){
                buyPointer=sellPointer;
            }
            else{
                max = Math.max(max,prices[sellPointer] - prices[buyPointer]);
            }
            sellPointer++;
        }
        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bts = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bts.maxProfit(prices));
        System.out.println(bts.betterSolution(prices));
    }
}

