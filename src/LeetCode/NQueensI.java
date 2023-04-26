package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NQueensI {
    private int[] rowByRow;
    private HashSet<Integer> cols, positiveDiagonal, negativeDiagonal;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n){
        rowByRow = new int[n];
        cols = new HashSet<>();
        positiveDiagonal = new HashSet<>();  // the / diagonals that are currently attacked
        negativeDiagonal = new HashSet<>();  // the \ diagonals that are currently attacked
        result = new LinkedList<>();
        nQueensRecursive(n,0);
        return result;
    }
    private void nQueensRecursive(int n, int row){
        if(row>=n){
            List<String> solution = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder queenPosition = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if(rowByRow[i]==j)queenPosition.append("Q");
                    else queenPosition.append(".");
                }
                solution.add(queenPosition.toString());
            }
            result.add(solution);
            return;
        }
        for(int col=0; col<n; col++){
            if(!cols.contains(col) && !positiveDiagonal.contains(n-1-col-row)
                                   && !negativeDiagonal.contains(row-col)){ // if the col is not attacked
                cols.add(col);
                positiveDiagonal.add(n-1-col-row);
                negativeDiagonal.add(row-col);
                rowByRow[row] = col;
                nQueensRecursive(n,row+1);
                cols.remove(col);
                positiveDiagonal.remove(n-1-col-row);
                negativeDiagonal.remove(row-col);
            }
        }
    }

    public static void main(String[] args) {
        NQueensI nq = new NQueensI();
        System.out.println(nq.solveNQueens(4));
    }
}
