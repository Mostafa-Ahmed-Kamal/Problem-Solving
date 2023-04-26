package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new LinkedList<>();
        dfs(graph,0,new LinkedList<>());
        return result;
    }
    void dfs(int[][] graph, int nodeIndex, List<Integer> path){
        path.add(nodeIndex);
        if(nodeIndex==graph.length-1){
            result.add(path);
        }
        for (int neighbor:graph[nodeIndex]){
            dfs(graph, neighbor, new LinkedList<>(path));
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget ap = new AllPathsFromSourceToTarget();
        int[][] graph = {{1,2},{3},{3},{}};
        System.out.println(ap.allPathsSourceTarget(graph));
    }
}
