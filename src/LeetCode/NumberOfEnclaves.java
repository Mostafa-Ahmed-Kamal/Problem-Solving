package LeetCode;

public class NumberOfEnclaves {
    private int[][] orientations = {{-1,0},{1,0},{0,1},{0,-1}};
    private boolean[][] visited;
    public int numEnclaves(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int enclavesCount = 0;
        for (int i = 0; i < grid.length; i++) {
            dfs(grid,i,0);
            dfs(grid,i,grid[0].length-1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid,0,i);
            dfs(grid,grid.length-1,i);
        }
        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                if (grid[i][j]==1 && !visited[i][j])enclavesCount++;
            }
        }
        return enclavesCount;
    }
    private void dfs(int[][] grid, int x, int y){
        if (outOfBound(grid,x,y) || visited[x][y] || grid[x][y]==0)return;
        visited[x][y] = true;
        for (int[] orientation:orientations){
            dfs(grid,x+orientation[0],y+orientation[1]);
        }
    }
    private boolean outOfBound(int[][] grid, int x, int y){
        return x<0||x>grid.length-1 || y<0 || y>grid[0].length-1;
    }

    public static void main(String[] args) {
        NumberOfEnclaves ne = new NumberOfEnclaves();
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(ne.numEnclaves(grid));
    }
}
