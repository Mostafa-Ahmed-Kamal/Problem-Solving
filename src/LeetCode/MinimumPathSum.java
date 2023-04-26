package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class MinimumPathSum {
    HashMap<Integer,Integer> visited;
    public int minPathSum(int[][] grid) {
        visited = new HashMap<>();
        return dfs(grid,0,0);
    }
    private int dfs(int[][] grid, int x, int y){
        int positionHash = x*300+y;
        if (visited.containsKey(positionHash))return visited.get(positionHash);
        int moveRight = outOfBound(grid,x+1,y)?Integer.MAX_VALUE:dfs(grid,x+1,y);
        int moveDown = outOfBound(grid,x,y+1)?Integer.MAX_VALUE:dfs(grid,x,y+1);
        visited.put(positionHash,moveDown==Integer.MAX_VALUE && moveRight==Integer.MAX_VALUE? grid[x][y]:grid[x][y]+Math.min(moveDown,moveRight));
        return visited.get(positionHash);
    }
    private boolean outOfBound(int[][] grid, int x, int y){
        return y>=grid[0].length || x>=grid.length;
    }

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();
        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.println(mps.minPathSum(grid));
    }
}
