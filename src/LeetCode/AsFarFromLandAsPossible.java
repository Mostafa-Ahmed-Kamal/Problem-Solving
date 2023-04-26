package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1){
                    queue.add(new int[] {i,j});
                    visited[i][j] = true;
                }
            }
        }
        int distance = -1;
        if(queue.size()==n*n)return -1;
        int[][] orientations = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] node = queue.poll();
                int nodeX = node[0], nodeY=node[1];
                for (int[] orientation:orientations){
                    int newNodeX = nodeX+orientation[0], newNodeY = nodeY+orientation[1];
                    if(outOfBound(newNodeX,newNodeY,n) || visited[newNodeX][newNodeY])continue;
                    queue.add(new int[] {newNodeX,newNodeY});
                    visited[newNodeX][newNodeY]=true;
                }
            }
            distance++;
        }
        return distance;
    }
    private boolean outOfBound(int x, int y, int n){
        return x<0 || y<0 || x>=n || y>=n;
    }

    public static void main(String[] args) {
        AsFarFromLandAsPossible aflp = new AsFarFromLandAsPossible();
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(aflp.maxDistance(grid));
    }
}
