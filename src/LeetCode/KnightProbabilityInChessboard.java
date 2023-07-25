package LeetCode;

import java.util.HashMap;

public class KnightProbabilityInChessboard {
    private final int[][] moves = {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{-1,-2},{1,2},{-1,2}};
    HashMap<Integer,HashMap<Integer,Double>> dp;
    public double knightProbability(int n, int k, int row, int column) {
        dp = new HashMap<>();
        return dp(n,k,row,column)/Math.pow(8,k);
    }
    private double dp(int n, int k, int row, int col){
        if (dp.containsKey(k)&& dp.get(k).containsKey(row*101+col)){
            return dp.get(k).get(row*101+col);
        }
        if (outOfBound(n,row,col)){
            return 0;
        }
        if (k<=0){
            return 1;
        }
        double totalValidPaths = 0;
        for (int[] move:moves){
            totalValidPaths += dp(n,k-1,row+move[0],col+move[1]);
        }
        dp.putIfAbsent(k,new HashMap<>());
        dp.get(k).put(row*101+col,totalValidPaths);
        return totalValidPaths;
    }
    private boolean outOfBound(int n, int row, int col){
        return row<0 || col<0 || row>=n || col>=n;
    }

    public static void main(String[] args) {
        KnightProbabilityInChessboard kpc = new KnightProbabilityInChessboard();
        int n = 3, k = 2, row = 0, column = 0;
        System.out.println(kpc.knightProbability(n,k,row,column));
    }
}
