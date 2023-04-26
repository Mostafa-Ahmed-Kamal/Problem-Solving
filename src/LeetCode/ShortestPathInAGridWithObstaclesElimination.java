package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int count = 0;
        boolean visited[][][] = new boolean[grid.length][grid[0].length][k+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,k});
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] positionK = queue.poll();
                int row = positionK[0], col = positionK[1], currentK = positionK[2];
                if(currentK<0 || visited[row][col][currentK])continue;
                if(row == grid.length-1 && col == grid[0].length-1) return count;
                visited[row][col][currentK] = true;
                if(row>0) queue.add(new int[] {row-1,col,grid[row-1][col]==1?currentK-1:currentK});
                if(row<grid.length-1) queue.add(new int[] {row+1,col,grid[row+1][col]==1?currentK-1:currentK});
                if(col>0) queue.add(new int[] {row,col-1,grid[row][col-1]==1?currentK-1:currentK});
                if(col<grid[0].length-1) queue.add(new int[] {row,col+1,grid[row][col+1]==1?currentK-1:currentK});

            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestPathInAGridWithObstaclesElimination s = new ShortestPathInAGridWithObstaclesElimination();
        int grid[][] = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}}, k = 1;
        System.out.println(s.shortestPath(grid,k));
    }

}
