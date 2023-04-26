package LeetCode;

import java.util.*;

public class MinimumTimeToCollectAllApplesInATree {
    HashSet<Integer>[] graph;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        graph = new HashSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int result = 0;
        for (int child:graph[0]){
            result+=minTimeRecursive(hasApple,child,0);
        }
        return result;
    }
    private int minTimeRecursive(List<Boolean> hasApple, int node, int parent){
        int minTime=0;
        for (int child:graph[node]){
            if(child==parent)continue;
            minTime+=minTimeRecursive(hasApple,child,node);
        }
        return hasApple.get(node) || minTime>0? minTime+2:0;
    }
    public static void main(String[] args) {
        MinimumTimeToCollectAllApplesInATree mt = new MinimumTimeToCollectAllApplesInATree();
        int n = 7, edges[][] = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> hasApple = Arrays.asList(false,false,true,false,true,true,false);
        System.out.println(mt.minTime(n,edges,hasApple));
    }
}
