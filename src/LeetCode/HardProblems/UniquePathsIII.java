package LeetCode.HardProblems;

public class UniquePathsIII {
    private boolean[][] visited;
    private int uniquePathsCounter;
    private static int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        uniquePathsCounter=0;
        int remainingSquare=0;
        int[] startingPosition = {0,0};
        for(int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if(grid[i][j]!=-1){
                    remainingSquare++;
                }
                if(grid[i][j]==1){
                    startingPosition = new int[] {i,j};
                }
            }
        }
        dfs(grid,startingPosition[0],startingPosition[1],remainingSquare);
        return uniquePathsCounter;
    }
    private boolean invalidPosition(int[][] grid, int row, int col){
        return row>=grid.length || row<0 || col>=grid[0].length || col<0 || grid[row][col]==-1 || visited[row][col];
    }
    private void dfs(int[][] grid, int row, int col, int remainingSquares){
        if(invalidPosition(grid,row,col)) return;
        remainingSquares--;
        if(grid[row][col] == 2 && remainingSquares==0){
            uniquePathsCounter++;
            return;
        }
        visited[row][col] = true;
        for(int[] move:moves){
            dfs(grid,row+move[0],col+move[1],remainingSquares);
        }
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        UniquePathsIII up3 = new UniquePathsIII();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(up3.uniquePathsIII(grid));
    }
}
