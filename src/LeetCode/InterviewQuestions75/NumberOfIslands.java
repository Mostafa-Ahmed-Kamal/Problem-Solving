package LeetCode.InterviewQuestions75;
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    count++;
                    travelIsland(grid,i,j);
                }
            }
        }
        return count;
    }
    public void travelIsland(char[][] grid, int row, int col){
        if(row<0 || row>= grid.length || col<0 || col>=grid[0].length || grid[row][col]=='0')return;
        grid[row][col] = '0';
        travelIsland(grid,row+1,col);
        travelIsland(grid,row,col+1);
        travelIsland(grid,row-1,col);
        travelIsland(grid,row,col-1);
    }

    public static void main(String[] args) {
        NumberOfIslands ni = new NumberOfIslands();
        char grid[][] = {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','0'}
        };
        System.out.println(ni.numIslands(grid));
    }
}
