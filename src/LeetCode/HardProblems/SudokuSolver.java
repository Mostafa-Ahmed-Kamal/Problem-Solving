package LeetCode.HardProblems;

import LeetCode.ValidSudoku;

import java.util.*;

public class SudokuSolver {
    public static final String possibleMoves = "123456789";
    public static class TakenMoves{
        HashSet<Character>[] rows;
        HashSet<Character>[] cols;
        HashSet<Character>[] blocks;
        public TakenMoves(char[][] board) {
            int n = board.length, m = board[0].length;
            rows = new HashSet[n];
            cols = new HashSet[n];
            blocks = new HashSet[n];
            for (int i = 0; i < n; i++) {
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                blocks[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char value = board[i][j];
                    if(value=='.')continue;
                    HashSet<Character> blockSet = blocks[(i / 3) * 3 + (j / 3)];
                    rows[i].add(value);
                    cols[j].add(value);
                    blockSet.add(value);
                }
            }
        }
    }
    void printBoard(char[][] board){
        if(board.length!=9 || board[0].length!=9)return;
        for(int i=0 ; i<3; i++){
            for (int l = i*3; l < i*3+3; l++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = j*3; k < j*3+3 ; k++) {
                        System.out.print(board[l][k] + " ");
                    }
                    System.out.print("| ");
                }
                System.out.println();
            }
            System.out.println("_______________________");
        }
    }
    public void solveSudoku(char[][] board) {
        bruteForceSolution(board,0,0,new TakenMoves(board));
    }
    public boolean bruteForceSolution(char[][] board, int i, int j, TakenMoves takenMoves){
        int nextI = j==8?i+1:i;
        int nextJ = (j+1)%9;
        if(board[i][j]!='.') {
            return i == 8 && j == 8 || bruteForceSolution(board, nextI, nextJ, takenMoves);
        }
        HashSet<Character> cols = takenMoves.cols[j];
        HashSet<Character> blocks = takenMoves.blocks[(i / 3) * 3 + (j / 3)];
        HashSet<Character> rows = takenMoves.rows[i];
        if(rows.size()==9 || cols.size()==9 || blocks.size()==9)return false;
        for (char move:possibleMoves.toCharArray()){
            if(blocks.contains(move) || cols.contains(move) || rows.contains(move))continue;
            blocks.add(move);cols.add(move);rows.add(move);
            board[i][j] = move;
            if(i==8 && j==8)return true;
            if(bruteForceSolution(board,nextI,nextJ,takenMoves))return true;
            blocks.remove(move);cols.remove(move);rows.remove(move);
            board[i][j] = '.';
        }
        return false;
    }

    public static void main(String[] args) {
        SudokuSolver ss = new SudokuSolver();
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

        ss.solveSudoku(board);
        ss.printBoard(board);
        ValidSudoku vs = new ValidSudoku();
        System.out.println("is valid solution? "+ (vs.isValidSudoku(board)?"YES":"NO"));
    }
}
