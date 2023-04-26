package LeetCode.InterviewQuestions75;

import java.util.LinkedList;
import java.util.Stack;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        // construct graph array representation
        for (int[] edge:edges){
            int edgeU = edge[0];
            int edgeV = edge[1];
            graph[edgeU].add(edgeV);
            graph[edgeV].add(edgeU);
        }
        stack.push(source);
        while(!stack.isEmpty()){
            int vertex = stack.pop();
            if(visited[vertex])
                continue;
            visited[vertex] = true;
            if(vertex==destination) return true;
            for (int neighbor:graph[vertex]) {
                if(!visited[neighbor]){
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph fg = new FindIfPathExistsInGraph();
        int n = 3, edges[][] = {{0,1},{1,2},{2,0}}, source = 1, destination = 2;
        System.out.println(fg.validPath(n,edges,source,destination));
    }
}
