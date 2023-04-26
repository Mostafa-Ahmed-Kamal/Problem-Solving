package LeetCode;

import java.util.Arrays;

public class Minesweeper {
    private int[][] orientations = {{-1,0},{1,0},{0,-1},{0,1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if(outOfBound(board,click[0],click[1]))return board;
        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
        }
        else if(board[click[0]][click[1]]=='E'){
            revealRecursive(board,click[0],click[1]);
        }
        return board;
    }
    private void revealRecursive(char[][] board, int X, int Y){
        if(outOfBound(board,X,Y) || revealed(board,X,Y))return;
        int bombCount = countBombs(board,X,Y);
        if(bombCount==0){
            board[X][Y]='B';
            for(int[] orientation:orientations){
                revealRecursive(board,X+orientation[0],Y+orientation[1]);
            }
            return;
        }
        board[X][Y]=(char)(bombCount+'0');
    }
    private int countBombs(char[][] board, int X, int Y){
        int bombCount=0;
        for(int[] orientation:orientations){
            int neighborX = X+orientation[0], neighborY = Y+orientation[1];
            if(outOfBound(board,neighborX,neighborY) || board[neighborX][neighborY]!='M')continue;
            bombCount++;
        }
        return bombCount;
    }
    private boolean outOfBound(char[][] board, int X, int Y){
        return X<0 || Y<0 || X>=board.length || Y>=board[0].length;
    }
    private boolean revealed(char[][] board, int X, int Y){
        return board[X][Y]!='M' && board[X][Y]!='E';
    }

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        char[][] board = {{'B','1','E','1','B'},{'B','1','M','1','B'},{'B','1','1','1','B'},{'B','B','B','B','B'}};
        int[] click = {1,2};
        System.out.println(Arrays.deepToString(minesweeper.updateBoard(board,click)));
    }
}
