package LeetCode.InterviewQuestions75;

public class WordSearch {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int currentIndex, int row, int col){
        if(word.length() == currentIndex) return true;
        if(row<0 || row>=board.length ||
            col<0 || col>=board[0].length ||
            visited[row][col] ||
            word.charAt(currentIndex) != board[row][col])
            return false;

        visited[row][col] = true;
        if(dfs(board,word,currentIndex+1,row+1,col))return true;
        if(dfs(board,word,currentIndex+1,row-1,col))return true;
        if(dfs(board,word,currentIndex+1,row,col+1))return true;
        if(dfs(board,word,currentIndex+1,row,col-1))return true;

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        board = new char[][] {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        System.out.println(ws.exist(board, "ABCESEEEFS"));
    }
}
