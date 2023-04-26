package LeetCode.InterviewQuestions75;

import java.util.Arrays;

public class RotateImage {

    public int[][] rotateBadSolution(int[][] matrix) {
        int n = matrix.length;
        int rotatedMatrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n-1-i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }

    public void rotate(int[][] matrix) {
        int storedValue;
        int n = matrix.length;
        int col_start = 0, col_end = n-1;
        int row = 0;
        int rowi, coli;
        while(col_start<col_end){
            for (int i = col_start; i < col_end; i++) {
                rowi = row;
                coli = i;
                storedValue = matrix[rowi][coli];
                for (int j = 0; j < 4; j++) {
                    int temp = storedValue;
                    storedValue = matrix[coli][n-1-rowi];
                    matrix[coli][n-1-rowi] = temp;
                    temp = coli;
                    coli = n-1-rowi;
                    rowi = temp;
                }
            }
            row++;
            col_start++;
            col_end--;
        }
    }

    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ri.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

}
