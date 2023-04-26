package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {
    List<Integer>[] children;
    int longestPath;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        longestPath = 1;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new LinkedList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }
        dfs(0,s,' ');
        return longestPath;
    }
    private int dfs(int node, String s, char parentsLabel){
        char nodesLabel = s.charAt(node);
        int longestNodePath = 0;
        int secondLongestNodePath = 0;
        for (int child:children[node]){
            int longestPath = dfs(child, s, nodesLabel);
            if(longestPath>longestNodePath){
                secondLongestNodePath = longestNodePath;
                longestNodePath = longestPath;
            }
            else if(longestPath>secondLongestNodePath){
                secondLongestNodePath = longestPath;
            }
        }
        int longestPathAsARoot = longestNodePath+secondLongestNodePath+1;
        longestPath = Math.max(longestPath,longestPathAsARoot);
        return nodesLabel==parentsLabel?0:longestNodePath+1;
    }
    public static void main(String[] args) {
        LongestPathWithDifferentAdjacentCharacters lp = new LongestPathWithDifferentAdjacentCharacters();
        int[] parent = {-1,0,0,1,1,2};
        String s = "abacbe";
        System.out.println(lp.longestPath(parent,s));
    }
}
