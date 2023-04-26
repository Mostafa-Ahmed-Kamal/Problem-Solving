package LeetCode;

import java.util.HashSet;

public class NQueensII {
    private HashSet<Integer> cols, positiveDiagonal, negativeDiagonal;
    int count;
    public int totalNQueens(int n){
        cols = new HashSet<>();
        positiveDiagonal = new HashSet<>();  // the / diagonals that are currently attacked
        negativeDiagonal = new HashSet<>();  // the \ diagonals that are currently attacked
        nQueensRecursive(n,0);
        return count;
    }
    private void nQueensRecursive(int n, int row){
        if(row>=n){
            count++;
            return;
        }
        for(int col=0; col<n; col++){
            if(!cols.contains(col) && !positiveDiagonal.contains(n-1-col-row)
                    && !negativeDiagonal.contains(row-col)){ // if the col is not attacked
                cols.add(col);
                positiveDiagonal.add(n-1-col-row);
                negativeDiagonal.add(row-col);
                nQueensRecursive(n,row+1);
                cols.remove(col);
                positiveDiagonal.remove(n-1-col-row);
                negativeDiagonal.remove(row-col);
            }
        }
    }

    public static void main(String[] args) {
        NQueensII nq = new NQueensII();
        System.out.println(nq.totalNQueens(4));
    }
}
