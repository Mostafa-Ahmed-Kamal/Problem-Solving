package LeetCode;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat[0].length;
        int start = 0, end = n-1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += start==end?mat[i][start]:mat[i][start]+mat[i][end];
            start++;
            end--;
        }
        return sum;
    }

    public static void main(String[] args) {
        MatrixDiagonalSum mds = new MatrixDiagonalSum();
        int[][] mat = {{1,2,3},{4,5,6}, {7,8,9}};
        System.out.println(mds.diagonalSum(mat));
    }
}
