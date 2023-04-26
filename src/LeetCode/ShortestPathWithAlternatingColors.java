package LeetCode;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    final int RED=0, BLUE=1;
    public class Node{
        // RED = 0; BLUE = 1
        List<Integer>[] neighbors;
        public Node(){
            neighbors = new LinkedList[2];
            for (int i = 0; i < neighbors.length; i++) {
                neighbors[i] = new LinkedList<>();
            }
        }
    }
    int[] shortestDistance;
    Node[] graphNodes;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        graphNodes = new Node[n];
        shortestDistance = new int[n];
        Arrays.fill(shortestDistance,-1);
        for (int i = 0; i < n; i++) {
            graphNodes[i] = new Node();
        }
        for (int[] redEdge:redEdges){
            graphNodes[redEdge[0]].neighbors[RED].add(redEdge[1]);
        }
        for (int[] blueEdge:blueEdges){
            graphNodes[blueEdge[0]].neighbors[BLUE].add(blueEdge[1]);
        }
        bfs(RED);
        bfs(BLUE);
        return shortestDistance;
    }
    private void bfs(int startingEdgeColor){
        boolean visited[][] = new boolean[graphNodes.length][2];
        Queue<Integer> queue = new LinkedList<>();
        int color = startingEdgeColor;
        queue.add(0);
        int distance = 0;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int nodeId = queue.poll();
                shortestDistance[nodeId] = shortestDistance[nodeId]==-1? distance:Math.min(shortestDistance[nodeId],distance);
                if(visited[nodeId][color])continue;
                visited[nodeId][color]=true;
                Node node = graphNodes[nodeId];
                queue.addAll(node.neighbors[color]);
            }
            distance++;
            color = (color+1) % 2;
        }
    }


    public static void main(String[] args) {
        ShortestPathWithAlternatingColors sc = new ShortestPathWithAlternatingColors();
        int n = 3, redEdges[][] = {{0,1},{1,2}}, blueEdges[][] = {{1,2}};
        System.out.println(Arrays.toString(sc.shortestAlternatingPaths(n,redEdges,blueEdges)));
    }
}
