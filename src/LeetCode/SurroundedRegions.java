package LeetCode;

import java.util.Arrays;

public class SurroundedRegions {
    final int[][] orientations = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] visited;
    int n,m;
    public void solve(char[][] board) {
        n = board.length; m=board[0].length;
        visited = new boolean[n][m];
        // vertical edges of the triangle
        for (int i = 0; i < n; i++) {
            travelIsland(board,i,0);
            travelIsland(board,i,m-1);
        }
        // horizontal edges of the triangle
        for (int i = 0; i < m; i++) {
            travelIsland(board,0,i);
            travelIsland(board,n-1,i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void travelIsland(char[][] board, int x,int y){
        if(outOfBound(x,y,n,m) || visited[x][y] || board[x][y]=='X')return;
        visited[x][y] = true;
        for (int[] orientation:orientations){
            travelIsland(board,x+orientation[0],y+orientation[1]);
        }
    }
    private boolean outOfBound(int x, int y, int n, int m){
        return x<0 || y<0 || x>=n || y>=m;
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        sr.solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
