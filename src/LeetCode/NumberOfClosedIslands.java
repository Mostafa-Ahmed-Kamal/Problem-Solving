package LeetCode;

public class NumberOfClosedIslands {
    private int[][] orientations = {{-1,0},{1,0},{0,1},{0,-1}};
    private boolean[][] visited;
    public int closedIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int isolatedIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] || grid[i][j]==1)continue;
                if (dfs(grid,i,j))isolatedIslands++;
            }
        }
        return isolatedIslands;
    }
    private boolean dfs(int[][] grid, int x, int y){
        if (outOfBound(grid,x,y))return false;
        if (visited[x][y] || grid[x][y]==1)return true;
        visited[x][y] = true;
        boolean isolated = true;
        for (int[] orientation:orientations){
            isolated &= dfs(grid,x+orientation[0],y+orientation[1]);
        }
        return isolated;
    }
    private boolean outOfBound(int[][] grid, int x, int y){
        return x<0||x>grid.length-1 || y<0 || y>grid[0].length-1;
    }
    public static void main(String[] args) {
        NumberOfClosedIslands ncs = new NumberOfClosedIslands();
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(ncs.closedIsland(grid));
    }
}
