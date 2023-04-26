package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NumberOfOperationsToMakeNetworkConnected {
    List<Integer>[] graph;
    boolean[] visited;
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)return -1;
        graph = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] connection:connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        int isolatedClusters = 0;
        for (int i = 0; i < n; i++) {
            if(visited[i])continue;
            isolatedClusters++;
            findCluster(i);
        }
        return isolatedClusters-1;
    }
    private void findCluster(int nodeId){
        if (visited[nodeId])return;
        visited[nodeId]=true;
        for (int neighbor:graph[nodeId]){
            if(!visited[neighbor])
                findCluster(neighbor);
        }
    }

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected nonc = new NumberOfOperationsToMakeNetworkConnected();
        int n = 4, connections[][] = {{0,1},{0,2},{1,2}};
        System.out.println(nonc.makeConnected(n,connections));
    }
}
