package TrianglzLiveCodingInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LiveCoding {
    public int[] uniqueNThatSumsToZero(int n){
        int[] result = new int[n];
        int iterator = n%2==0?0:1;
        int numberToAdd = 1;
        for (; iterator < n; iterator+=2) {
            result[iterator] = numberToAdd;
            result[iterator+1] = -numberToAdd;
            numberToAdd++;
        }
        return result;
    }
    public int townJudge(int n, int[][] trusts){
        HashSet<Integer>[] trust = new HashSet[n+1];
        HashSet<Integer>[] trustedBy = new HashSet[n+1];
        for (int[] trustLink:trusts){
            if (trust[trustLink[0]]==null){
                trust[trustLink[0]] = new HashSet<>();
            }
            if (trustedBy[trustLink[1]]==null){
                trustedBy[trustLink[1]] = new HashSet<>();
            }
            trust[trustLink[0]].add(trustLink[1]);
            trustedBy[trustLink[1]].add(trustLink[0]);
        }
        for (int i = 1; i <= n; i++) {
            int trustsCount = trust[i]==null?0:trust[i].size();
            int trustedByCount = trustedBy[i]==null?0:trustedBy[i].size();
            if (trustsCount==0 && trustedByCount==n-1)return i;
        }
        return -1;
    }
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char value = board[row][col];
                if (value != '.') {
                    // Check row
                    if (rows[row].contains(value)) {
                        return false;
                    } else {
                        rows[row].add(value);
                    }
                    // Check column
                    if (columns[col].contains(value)) {
                        return false;
                    } else {
                        columns[col].add(value);
                    }
                    // Check box
                    int boxIndex = (row / 3) * 3 + (col / 3);
                    if (boxes[boxIndex].contains(value)) {
                        return false;
                    } else {
                        boxes[boxIndex].add(value);
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LiveCoding liveCoding = new LiveCoding();
//        System.out.println(Arrays.toString(liveCoding.uniqueNThatSumsToZero(1)));
//        int n = 3, trust[][] = {{1,3},{2,3},{3,1}};
//        System.out.println(liveCoding.townJudge(n,trust));
        char[][] sudokuBoard =
                {{'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        boolean isValid = isValidSudoku(sudokuBoard);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }
}
