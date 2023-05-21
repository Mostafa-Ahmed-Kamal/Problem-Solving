package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    private final int[][] orientations = {{-1,0},{1,0},{0,1},{0,-1}};
    boolean[][] visited;
    Queue<int[]> queue;
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        queue = new LinkedList<>();
        travelFirstIsland(grid,n,m);
        int bridgeLength = 0;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = queue.poll();
                assert node != null;
                for (int[] orientation:orientations){
                    int neighborX = node[0]+orientation[0];
                    int neighborY = node[1]+orientation[1];
                    if (outOfBound(neighborX,neighborY,grid) || visited[neighborX][neighborY])continue;
                    if (grid[neighborX][neighborY]==1)return bridgeLength;
                    visited[neighborX][neighborY] = true;
                    queue.add(new int[] {neighborX,neighborY});
                }
            }
            bridgeLength++;
        }
        return -1;
    }
    private void travelFirstIsland(int[][] grid,int n,int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1){
                    dfs(grid,i,j);
                    return;
                }
            }
        }
    }
    private void dfs(int[][] grid, int x, int y){
        if (outOfBound(x,y,grid) || grid[x][y]==0 || visited[x][y])return;
        visited[x][y] = true;
        queue.add(new int[] {x,y});
        for (int[] orientation:orientations){
            dfs(grid,orientation[0]+x,orientation[1]+y);
        }
    }
    private boolean outOfBound(int x, int y, int[][] grid){
        return x<0 || y<0 || x>=grid.length || y>=grid[0].length;
    }

    public static void main(String[] args) {
        ShortestBridge sb = new ShortestBridge();
        int[][] grid = {{0,1,0},{0,0,0},{0,0,1}};
        System.out.println(sb.shortestBridge(grid));
    }
}
