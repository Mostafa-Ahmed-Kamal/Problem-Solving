package LeetCode;

public class MinimumFallingPathSum {
    private int[][] dp;
    private boolean[][] visited;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new int[n-1][n];
        visited = new boolean[n-1][n];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int minFallingSumStartingFromI = minFallingPathSumRecursive(matrix,0,i);
            result = Math.min(result, minFallingSumStartingFromI);
        }
        return result;
    }
    private int minFallingPathSumRecursive(int[][] matrix, int row, int col){
        if(row==matrix.length-1)return matrix[row][col];
        if(visited[row][col]){
            return dp[row][col];
        }
        int min = Math.max(0,col-1);
        int max = Math.min(matrix.length-1,col+1);
        int minFallingSum = Integer.MAX_VALUE;
        for (int i = min; i <= max ; i++) {
            int currentFallingPath = minFallingPathSumRecursive(matrix, row+1,i);
            minFallingSum = Math.min(minFallingSum, currentFallingPath);
        }
        minFallingSum += matrix[row][col];
        dp[row][col] = minFallingSum;
        visited[row][col] = true;
        return minFallingSum;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum ms = new MinimumFallingPathSum();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(ms.minFallingPathSum(matrix));
    }
}
