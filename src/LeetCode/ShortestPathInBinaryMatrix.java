package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    final int[][] orientations = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[n-1][n-1]==1)return -1;
        int[] target = {n-1,n-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        int distance = 1;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] position = queue.poll();
                if(Arrays.equals(position,target))return distance;
                if(outOfBound(position[0],position[1],n) || grid[position[0]][position[1]]==1)continue;
                grid[position[0]][position[1]]=1;
                for (int[] orientation:orientations){
                    queue.add(new int[] {position[0]+orientation[0],position[1]+orientation[1]});
                }
            }
            distance++;
        }
        return -1;
    }
    private boolean outOfBound(int x, int y, int n){
        return x<0 || y<0 || x>=n || y>=n;
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix sm = new ShortestPathInBinaryMatrix();
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(sm.shortestPathBinaryMatrix(grid));
    }
}
