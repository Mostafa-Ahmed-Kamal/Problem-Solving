package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {
    boolean[] visited;
    List<Integer>[] graph;
    public long countPairs(int n, int[][] edges) {
        graph = new List[n];
        visited = new boolean[n];
        long visitedNodesCount = 0;
        long unreachablePairsCount = 0;
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if(visited[i])continue;
            long islandSize = islandSize(i);
            unreachablePairsCount+= visitedNodesCount*islandSize;
            visitedNodesCount+=islandSize;
        }
        return unreachablePairsCount;
    }
    private long islandSize(int node){
        if (visited[node])return 0;
        long nodesCount = 1;
        visited[node] = true;
        for (int neighbor: graph[node]){
            nodesCount+=islandSize(neighbor);
        }
        return nodesCount;
    }

    public static void main(String[] args) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph cu = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        int n = 7, edges[][] = {{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println(cu.countPairs(n,edges));
    }
}
