package LeetCode.HardProblems;
import java.util.HashMap;

public class TallestBillboard {
    HashMap<Integer,Integer>[] dp;
    public int tallestBillboard(int[] rods) {
        dp = new HashMap[rods.length];
        for (int i = 0; i < rods.length; i++) {
            dp[i] = new HashMap<>();
        }
        return dp(rods,0,0);
    }
    private int dp(int[] rods, int rodID, int difference){
        if(rodID>=rods.length)return difference==0? 0:Integer.MIN_VALUE;
        if (dp[rodID].containsKey(difference))return dp[rodID].get(difference);
        int take = Math.max(rods[rodID] + dp(rods, rodID+1, difference+rods[rodID]),
                (rods[rodID]>difference?rods[rodID]-difference:0) + dp(rods, rodID+1, Math.abs(rods[rodID]-difference)));
        int leave = dp(rods,rodID+1,difference);
        int bestStrategy = Math.max(take,leave);
        dp[rodID].put(difference,bestStrategy);
        return bestStrategy;
    }
    public static void main(String[] args) {
        TallestBillboard tbb = new TallestBillboard();
        int[] rods = {1,2,3,4,5,6};
        System.out.println(tbb.tallestBillboard(rods));
    }
}
