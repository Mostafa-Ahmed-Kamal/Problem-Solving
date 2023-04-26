package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        Stack<int[]> zeroes = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0)zeroes.add(new int[] {i,j});
            }
        }
        while (!zeroes.isEmpty()){
            int zero[] = zeroes.pop();
            unsetRowAndCol(matrix, zero[0], zero[1]);
        }
    }

    public void unsetRowAndCol(int[][] matrix, int row, int col){
        int max = Math.max(matrix.length, matrix[0].length);
        for (int i = 0; i < max; i++) {
            if(i<matrix.length) matrix[i][col] = 0;
            if(i<matrix[0].length) matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int matrix[][] = {{1,1,1},{1,0,1},{1,1,1},{1,1,1}};
        smz.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
