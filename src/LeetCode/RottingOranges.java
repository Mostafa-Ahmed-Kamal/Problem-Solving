package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
// solution is O(n*m)
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int minutesElapsed = -1;
        Queue<Integer[]> freshRotten = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==2){
                    freshRotten.add(new Integer[]{i,j});
                }
            }
        }
        while(!freshRotten.isEmpty()){
            minutesElapsed++;
            int currentSize = freshRotten.size();
            for (int i = 0; i < currentSize; i++) {
                Integer[] rotten = freshRotten.poll();
                if(rotten[0]>0 && grid[rotten[0]-1][rotten[1]]==1){
                    grid[rotten[0]-1][rotten[1]]=2;
                    freshRotten.add(new Integer[] {rotten[0]-1,rotten[1]});
                }
                if(rotten[0]<grid.length-1 && grid[rotten[0]+1][rotten[1]]==1){
                    grid[rotten[0]+1][rotten[1]]=2;
                    freshRotten.add(new Integer[] {rotten[0]+1,rotten[1]});
                }
                if(rotten[1]>0 && grid[rotten[0]][rotten[1]-1]==1){
                    grid[rotten[0]][rotten[1]-1]=2;
                    freshRotten.add(new Integer[] {rotten[0],rotten[1]-1});
                }
                if(rotten[1]<grid[0].length-1 && grid[rotten[0]][rotten[1]+1]==1){
                    grid[rotten[0]][rotten[1]+1]=2;
                    freshRotten.add(new Integer[] {rotten[0],rotten[1]+1});
                }
            }
        }
        /** Check that all oranges are rotten **/
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1)return -1;
            }
        }
        return Math.max(minutesElapsed,0);
    }

    public static void main(String[] args) {
        RottingOranges ro = new RottingOranges();
        int[][] grid;
        grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}}; //Output: 4
        System.out.println(ro.orangesRotting(grid));

        grid = new int[][]{{0,2}}; //Output: 0
        System.out.println(ro.orangesRotting(grid));

        grid = new int[][]{{0,2,2}}; //Output: 0
        System.out.println(ro.orangesRotting(grid));

    }
}
