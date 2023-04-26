package LeetCode;
import java.util.*;

public class WordSearchII {
    private class Trie{
        boolean isFinal;
        String value;
        HashMap<Character,Trie> children;
        public Trie(){
            children = new HashMap<>();
        }
    }
    HashSet<String> result;
    boolean visited[][];
    public List<String> findWords(char[][] board, String[] words) {
        result = new HashSet<>();
        int n = board.length, m = board[0].length;
        Trie root = new Trie();
        // array construction
        for (String word:words){
            Trie currentNode = root;
            for (char c:word.toCharArray()){
                currentNode.children.putIfAbsent(c,new Trie());
                currentNode = currentNode.children.get(c);
            }
            currentNode.isFinal = true;
            currentNode.value = word;
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board,root,i,j);
            }
        }
        return result.stream().toList();
    }

    public void dfs(char[][] board, Trie node, int row, int col){
        if(row<0 || col<0 || row >= board.length || col >= board[0].length ||
                visited[row][col] || !node.children.containsKey(board[row][col])) return;
        visited[row][col]=true;
        Trie newNode = node.children.get(board[row][col]);
        if(newNode.isFinal) result.add(newNode.value);
        dfs(board,newNode,row+1,col);
        dfs(board,newNode,row-1,col);
        dfs(board,newNode,row,col+1);
        dfs(board,newNode,row,col-1);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        WordSearchII ws2 = new WordSearchII();
        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String words[] = {"oath","pea","eat","rain"};
        System.out.println(ws2.findWords(board,words));
    }
}
