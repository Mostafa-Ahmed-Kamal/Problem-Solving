package LeetCode;
import java.util.HashMap;

public class EqualRowAndColumnPairs {
    private static class Trie{
        HashMap<Integer,Trie> children;
        int leafCount;
        public Trie(){
            children = new HashMap<>();
            leafCount = 0;
        }
    }
    private final Trie root = new Trie();
    public int equalPairs(int[][] grid) {
        for (int[] sequence:grid){
            addSequence(sequence);
        }
        int equalsCount = 0;
        for (int i = 0; i < grid[0].length; i++) {
            Trie node = root;
            for (int[] ints : grid) {
                if(!node.children.containsKey(ints[i]))break;
                node = node.children.get(ints[i]);
            }
            equalsCount += node.leafCount;
        }
        return equalsCount;
    }
    private void addSequence(int[] sequence){
        Trie node = root;
        for (int value:sequence){
            node.children.putIfAbsent(value, new Trie());
            node = node.children.get(value);
        }
        node.leafCount++;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPairs erc = new EqualRowAndColumnPairs();
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(erc.equalPairs(grid));
    }
}
