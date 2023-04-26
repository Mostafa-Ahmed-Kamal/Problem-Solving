package LeetCode;

import java.util.*;

public class MinimumScoreOfAPathBetweenTwoCities {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        boolean[] visited = new boolean[n+1];
        for (int road[]:roads){
            graph.putIfAbsent(road[0],new LinkedList<>());
            graph.putIfAbsent(road[1],new LinkedList<>());
            graph.get(road[0]).add(new int[] {road[1],road[2]});
            graph.get(road[1]).add(new int[] {road[0],road[2]});
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        int minScore = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int city = queue.poll();
            if(visited[city])continue;
            visited[city]=true;
            for(int[] neighbors: graph.get(city)) {
                queue.add(neighbors[0]);
                minScore = Math.min(minScore,neighbors[1]);
            }
        }
        return minScore;
    }

    public static void main(String[] args) {
        MinimumScoreOfAPathBetweenTwoCities ms = new MinimumScoreOfAPathBetweenTwoCities();
        int n = 4, roads[][] = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(ms.minScore(n,roads));
    }
}
