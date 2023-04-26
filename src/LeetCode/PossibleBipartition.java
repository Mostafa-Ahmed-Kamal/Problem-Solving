package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PossibleBipartition {
    // the algorithm is based on checking if a graph is bipartite or not
    // a bipartite graph is a graph that can be divided into two sets were
    // all edges connect a vertex from the first set to the second one
    public boolean possibleBipartition(int n, int[][] dislikes) {
        LinkedList<Integer>[] graph = new LinkedList[n];
        // 0-->not visited, 1-->group A, 2-->group B
        int[] nodeColors = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] dislike:dislikes){
            int first = dislike[0]-1, second = dislike[1]-1;
            graph[first].add(second);
            graph[second].add(first);
        }
        for (int i = 0; i < n; i++) {
            if(nodeColors[i]!=0)continue;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {i,1});
            while(!queue.isEmpty()){
                int[] nodeColor = queue.poll();
                int node=nodeColor[0], color = nodeColor[1];
                if(nodeColors[node]==0) {
                    nodeColors[node] = color;
                    for (int neighbor:graph[node]){
                        queue.add(new int[]{neighbor,oppositeColor(color)});
                    }
                }
                if(nodeColors[node]!=color)
                    return false;
            }
        }
        return true;
    }
    private int oppositeColor(int color){
        return color==1?2:1;
    }

    public static void main(String[] args) {
        PossibleBipartition pb = new PossibleBipartition();
        int n = 4, dislikes[][] = {{1,2},{1,3},{1,4}};
        System.out.println(pb.possibleBipartition(n,dislikes));
    }
}
