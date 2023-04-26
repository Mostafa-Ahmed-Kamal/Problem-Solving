package LeetCode.InterviewQuestions75;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralMatrix = new LinkedList<>();
        int col_start =0,row_start=0, col_end=matrix[0].length-1, row_end= matrix.length-1;
        int count = matrix.length * matrix[0].length;
        while(count>0){
            for (int i = col_start; i <= col_end && count>0; i++,count--) {
                spiralMatrix.add(matrix[row_start][i]);
            }
            row_start++;

            for (int i = row_start; i <= row_end && count>0; i++,count--) {
                spiralMatrix.add(matrix[i][col_end]);
            }
            col_end--;

            for (int i = col_end; i >= col_start && count>0; i--,count--) {
                spiralMatrix.add(matrix[row_end][i]);
            }
            row_end--;

            for (int i = row_end; i >= row_start && count>0; i--,count--) {
                spiralMatrix.add(matrix[i][col_start]);
            }
            col_start++;
        }
        return spiralMatrix;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(sm.spiralOrder(matrix));
    }
}
