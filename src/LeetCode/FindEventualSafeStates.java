package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class FindEventualSafeStates {
    int[] safeState;
    boolean[] visited;
    // -1 false, 1 true, 0 unvisited
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new LinkedList<>();
        safeState = new int[graph.length];
        visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafeState(graph,i)){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    private boolean isSafeState(int[][] graph, int nodeID){
        if (safeState[nodeID]!=0)return safeState[nodeID]==1;
        if (visited[nodeID])return false;
        visited[nodeID]=true;
        for (int neighbor:graph[nodeID]) {
            if (!isSafeState(graph, neighbor)) {
                safeState[nodeID]=-1;
                return false;
            }
        }
        visited[nodeID]=false;
        safeState[nodeID]=1;
        return true;
    }

    public static void main(String[] args) {
        FindEventualSafeStates fss = new FindEventualSafeStates();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(fss.eventualSafeNodes(graph));
    }
}
