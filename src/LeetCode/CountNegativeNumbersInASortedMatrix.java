package LeetCode;

public class CountNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        int m = grid[0].length;
        int colPassenger = m;
        int count = 0;
        for (int[] row : grid) {
            while (colPassenger != 0 && row[colPassenger - 1] < 0) {
                colPassenger--;
            }
            count += m - colPassenger;
        }
        return count;
    }

    public static void main(String[] args) {
        CountNegativeNumbersInASortedMatrix cn = new CountNegativeNumbersInASortedMatrix();
        int[][] grid = {{5,1,0},{-5,-5,-5}};
        System.out.println(cn.countNegatives(grid));
    }
}
