package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 *
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        int minI = 0;
        int minJ = 0;
        int maxI = matrix.length-1;
        int maxJ = matrix[0].length-1;
        int numberOfCells = (maxI+1)*(maxJ+1);
        int i=0,j=0;
        boolean goingRight = true, goingDown = true;
        while(numberOfCells>0){
            if(goingRight) { //going right
                for (; j <= maxJ; j++) {
                    list.add(matrix[i][j]);
                    numberOfCells--;
                }
                j--;
                i++;
                minJ++;
                maxJ--;
            }
            else{ // going left
                for (; j >= minJ-1; j--) {
                    list.add(matrix[i][j]);
                    numberOfCells--;
                }
                j++;
                i--;
            }
            if(goingDown){ // going down
                for (; i <= maxI; i++) {
                    list.add(matrix[i][j]);
                    numberOfCells--;
                }
                i--;
                j--;
                minI++;
                maxI--;
            }
            else{ // going up
                for (; i >= minI; i--) {
                    list.add(matrix[i][j]);
                    numberOfCells--;
                }
                i++;
                j++;
            }
            goingDown = !goingDown;
            goingRight = !goingRight;
        }
        return list;
    }

    public static void main(String[] args) {
        SpiralMatrix sp = new SpiralMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(sp.spiralOrder(matrix));
        // Output: [1,2,3,6,9,8,7,4,5]
        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(sp.spiralOrder(matrix));
        // Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        matrix = new int[][]{{7},{9},{6}};
        System.out.println(sp.spiralOrder(matrix));
        // Output: [7,9,6]
        matrix = new int[][]{{1,2},{3,4}};
        System.out.println(sp.spiralOrder(matrix));
        // Output: [1,2,4,3]
        matrix = new int[][]{{2,5,8},{4,0,-1}};
        System.out.println(sp.spiralOrder(matrix));
        // Output: [2,5,8,-1,0,4]

    }
}
