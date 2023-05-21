package LeetCode;

import java.util.Arrays;

public class IsGraphBipartite {
    int[] distinguishSet;
    public boolean isBipartite(int[][] graph) {
        distinguishSet = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (distinguishSet[i]==0 && !dfs(graph,i,1))return false;
        }
        return true;
    }
    public boolean dfs(int[][] graph, int node, int set){
        if (distinguishSet[node]==set)return true;
        int otherSet = set==1?-1:1;
        if (distinguishSet[node]==otherSet)return false;
        distinguishSet[node]=set;
        for (int neighbor:graph[node]){
            if(!dfs(graph,neighbor,otherSet))return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsGraphBipartite igb = new IsGraphBipartite();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(igb.isBipartite(graph));
    }
}
