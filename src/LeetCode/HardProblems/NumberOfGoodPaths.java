package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberOfGoodPaths {
    /// uses union find algorithm
    int[] parents;
    int[] goodPathsPerSet;
    int goodPaths;
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        goodPaths = n;
        parents = new int[n];
        goodPathsPerSet = new int[n];
        Arrays.fill(goodPathsPerSet,1);
        Arrays.sort(edges, Comparator.comparingInt(o -> Math.max(vals[o[0]], vals[o[1]])));
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge:edges){
            union(vals, edge[0], edge[1]);
        }
        return goodPaths;
    }
    private void union(int[] vals, int nodeA, int nodeB){
        int parentA = find(nodeA);
        int parentB = find(nodeB);
        if(parentA==parentB)return;
        if(vals[parentA]==vals[parentB]){
            goodPaths += goodPathsPerSet[parentA]*goodPathsPerSet[parentB];
            goodPathsPerSet[parentA] += goodPathsPerSet[parentB];
            parents[parentB] = parentA;
        }
        else if(vals[parentA]>vals[parentB]){
            parents[parentB] = parentA;
        }
        else{
            parents[parentA] = parentB;
        }
    }
    private int find(int node){
        int parent = parents[node];
        while(parent!=parents[parent]){
            parent = parents[parent];
        }
        parents[node] = parent;
        return parent;
    }

    public static void main(String[] args) {
        NumberOfGoodPaths nb = new NumberOfGoodPaths();
        int vals[] = {1,3,2,1,3}, edges[][] = {{0,1},{0,2},{2,3},{2,4}};
        System.out.println(nb.numberOfGoodPaths(vals, edges));
    }

}
