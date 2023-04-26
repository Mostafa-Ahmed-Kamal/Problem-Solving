package LeetCode.HardProblems;

import java.util.HashMap;
import java.util.HashSet;

public class LongestCycleInAGraph {
    private boolean[] visited;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        visited = new boolean[n];
        int maxCycle = -1;
        for (int i = 0; i < n; i++) {
            maxCycle = Math.max(maxCycle,dfsWithCycle(i,0,edges,new HashMap<>()));
        }
        return maxCycle;
    }
    private int dfsWithCycle(int node, int hop, int[] edges, HashMap<Integer,Integer> visitedNodesInPath){
        if (visitedNodesInPath.containsKey(node))return hop-visitedNodesInPath.get(node);
        if (visited[node])return -1;
        visited[node] = true;
        visitedNodesInPath.put(node,hop);
        return edges[node]==-1? -1:dfsWithCycle(edges[node], hop+1, edges, visitedNodesInPath);
    }

    public static void main(String[] args) {
        LongestCycleInAGraph lag = new LongestCycleInAGraph();
        int[] edges = {2,-1,3,1};
        System.out.println(lag.longestCycle(edges));
    }
}
