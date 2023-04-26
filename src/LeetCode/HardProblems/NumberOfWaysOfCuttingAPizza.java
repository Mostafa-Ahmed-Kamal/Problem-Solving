package LeetCode.HardProblems;

import java.util.Arrays;

public class NumberOfWaysOfCuttingAPizza {
    int[][][] dp;
    private final int MOD = (int)Math.pow(10,9) + 7;
    public int ways(String[] pizza, int k) {
        dp = new int[pizza.length][pizza[0].length()][k];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i][j][l]=-1;
                }
            }
        }
        waysToCutPizzaRecursive(pizza,k-1,0,0);
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0][k-1];
    }
    private int waysToCutPizzaRecursive(String[] pizza, int k, int row, int col){
        if(k==0)return 1;
        if(dp[row][col][k]!=-1)return dp[row][col][k];
        int applesCount=countApples(pizza,row,col);
        if (applesCount<k) {
            dp[row][col][k]=0;
            return 0;
        }
        int numberOfWays = 0;
        int startingRow = row, startingCol = col;
        for (; startingRow < pizza.length-1; startingRow++) {
            if(containsApple(pizza[startingRow],col)) break;
        }
        for (int i = startingRow; i < pizza.length-1; i++) {
            numberOfWays=(numberOfWays+waysToCutPizzaRecursive(pizza,k-1,i+1,col))%MOD;
        }
        for (;startingCol < pizza[0].length()-1; startingCol++) {
            if(containsApple(pizza,row,startingCol)) break;
        }
        for (int i = startingCol; i < pizza[0].length()-1; i++) {
            numberOfWays=(numberOfWays+waysToCutPizzaRecursive(pizza,k-1,row,i+1))%MOD;
        }
        dp[row][col][k] = numberOfWays%MOD;
        return dp[row][col][k];
    }
    private boolean containsApple(String row, int col){
        for (int i = col; i < row.length(); i++) {
            if (row.charAt(i)=='A')return true;
        }
        return false;
    }
    private boolean containsApple(String[] pizza, int row, int col){
        for (int i = row; i < pizza.length; i++) {
            if (pizza[i].charAt(col)=='A')return true;
        }
        return false;
    }
    private int countApples(String[] pizza, int row, int col){
        int apples=0;
        for (int i = row; i < pizza.length; i++) {
            for (int j = col; j < pizza[0].length(); j++) {
                if(pizza[i].charAt(j)=='A')apples++;
            }
        }
        return apples;
    }

    public static void main(String[] args) {
        NumberOfWaysOfCuttingAPizza np = new NumberOfWaysOfCuttingAPizza();
        String[] pizza = {"A..","AAA","..."};
        int k = 3;
        System.out.println(np.ways(pizza,k));
    }
}
