package LeetCode;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int value, minEnd;
        int height = matrix.length, width = matrix[0].length;
        for(int i=0; i<height; i++){
            value = matrix[i][0];
            minEnd = Math.min(height-i,width);
            for(int j=0; j<minEnd; j++) {
                if (matrix[i+j][j] != value) return false;
            }
        }
        for(int i=1; i<width; i++){
            value = matrix[0][i];
            minEnd = Math.min(height,width-i);
            for(int j=0; j<minEnd; j++) {
                if (matrix[j][i+j] != value) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix tm = new ToeplitzMatrix();
        int matrix[][] = {{11,74,0,93},{40,11,74,7}};
        System.out.println(tm.isToeplitzMatrix(matrix));
    }
}
