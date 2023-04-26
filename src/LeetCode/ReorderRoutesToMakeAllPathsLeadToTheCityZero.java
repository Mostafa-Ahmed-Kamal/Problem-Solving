package LeetCode;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] connection:connections){
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(-connection[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int minReorder = 0;
        queue.add(0);
        while (!queue.isEmpty()){
            int nodeId = queue.poll();
            visited[nodeId]=true;
            for (int neighbor:graph[nodeId]){
                if(visited[Math.abs(neighbor)])continue;
                if(neighbor>0)minReorder++;
                queue.add(Math.abs(neighbor));
            }
        }
        return minReorder;
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero r= new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        int n = 6, connections[][] = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(r.minReorder(n,connections));
    }
}
