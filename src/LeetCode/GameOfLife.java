package LeetCode;

import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] history = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                history[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = aliveOrDead(history,i,j);
            }
        }
    }
    private boolean outOfBound(int x, int y, int[][] board){
        return x<0 || y<0 || x>=board.length || y>=board[0].length;
    }
    public int aliveOrDead(int[][] board, int x, int y){
        int[][] orientations = {{-1,-1},{-1,1},{-1,0},{1,0},{1,-1},{1,1},{0,1},{0,-1}};
        int aliveNeighbors = 0;
        for (int[] orientation:orientations){
            aliveNeighbors += outOfBound(x+orientation[0],y+orientation[1],board)?0:board[x+orientation[0]][y+orientation[1]];
        }
        return (board[x][y]==1 && (aliveNeighbors==2)) ||  aliveNeighbors==3?1:0;
    }

    public static void main(String[] args) {
        GameOfLife gof = new GameOfLife();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gof.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
