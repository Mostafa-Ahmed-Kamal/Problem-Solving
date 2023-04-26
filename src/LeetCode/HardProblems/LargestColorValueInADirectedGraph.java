package LeetCode.HardProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LargestColorValueInADirectedGraph {
    int[][] pathColors;
    HashMap<Integer, List<Integer>> graph;
    HashSet<Integer> visited;
    HashSet<Integer> pathNodes;
    public int largestPathValue(String colors, int[][] edges) {
        graph = new HashMap<>();
        int n = colors.length();
        pathColors = new int[n][26];
        visited = new HashSet<>();
        pathNodes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            graph.put(i,new LinkedList<>());
        }
        for (int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result,dfs(i,colors));
        }
        return result == Integer.MAX_VALUE?-1:result;
    }
    private int dfs(int nodeId, String colors){
        if (pathNodes.contains(nodeId))return Integer.MAX_VALUE;
        if (visited.contains(nodeId))return 0;
        visited.add(nodeId);
        pathNodes.add(nodeId);
        int colorIndex = colors.charAt(nodeId) - 'a';
        pathColors[nodeId][colorIndex] = 1;
        int max = 0;
        for (int neighbor:graph.get(nodeId)){
            if (dfs(neighbor,colors)==Integer.MAX_VALUE)return Integer.MAX_VALUE;
            for (int c = 0; c < 26; c++) {
                pathColors[nodeId][c] = Math.max(
                        pathColors[nodeId][c],
                        (colorIndex==c?0:1) + pathColors[neighbor][c]
                );
                max = Math.max(max,pathColors[nodeId][c]);
            }
        }
        pathNodes.remove(nodeId);
        return max;
    }

    public static void main(String[] args) {
        LargestColorValueInADirectedGraph lc = new LargestColorValueInADirectedGraph();
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        String colors = "abaca";
        System.out.println(lc.largestPathValue(colors,edges));
    }
}
