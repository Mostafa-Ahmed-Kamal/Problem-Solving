package LeetCode;

/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 */
public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        return searchMatrixRecursive(matrix , target, new int[] {0,0} , new int[] {matrix.length-1,matrix[0].length-1});
    }
    public boolean searchMatrixRecursive(int[][] matrix , int target, int[] start , int[] end){

        int[] mid = new int[2];
        int startIndex = start[0]*matrix[0].length + start[1];
        int endIndex = end[0]*matrix[0].length + end[1];
        int nOfElements = endIndex - startIndex+1;

        if(nOfElements<=0)return false;
        nOfElements/=2;
        mid[0] = (startIndex + nOfElements) / matrix[0].length;
        mid[1] = (startIndex + nOfElements) % matrix[0].length;

        if(matrix[mid[0]][mid[1]]==target)return true;
        else if(matrix[mid[0]][mid[1]]>target){
            mid[0] = mid[1]==0?mid[0]-1:mid[0];
            mid[1] = mid[1]==0?matrix[0].length-1:mid[1]-1;
            return searchMatrixRecursive(matrix , target, start , mid);

        }
        else {
            mid[0] = mid[1]==matrix[0].length-1?mid[0]+1:mid[0];
            mid[1] = (mid[1]+1)%matrix[0].length;
            return searchMatrixRecursive(matrix , target, mid , end);
        }
    }

    public static void main(String[] args) {
        SearchA2DMatrix s2d = new SearchA2DMatrix();
        int[][] matrix;
        matrix =new int[][]{{1,2,3},{4,5,6}};
        System.out.println(s2d.searchMatrix(matrix,2)); //true

        matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(s2d.searchMatrix(matrix,6)); //false
        System.out.println(s2d.searchMatrix(matrix,11)); //true
        System.out.println(s2d.searchMatrix(matrix,21)); //false
        System.out.println(s2d.searchMatrix(matrix,3));//true

        matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(s2d.searchMatrix(matrix,13));//false

    }
}
