package LeetCode.InterviewQuestions75;

import java.util.*;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 *
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 *
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * Example 2:
 *
 * Input: heights = [[2,1],[1,2]]
 * Output: [[0,0],[0,1],[1,0],[1,1]]
 */
public class PacificAtlanticWaterFlow {
    int COL, ROW;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        List<List<Integer>> result = new LinkedList<>();
        boolean pacific[][] = new boolean[ROW][COL];
        boolean atlantic[][] = new boolean[ROW][COL];
        for (int c = 0; c < COL; c++) {
            dfs(0,c,pacific,heights[0][c],heights);
            dfs(ROW-1,c,atlantic,heights[ROW-1][c],heights);
        }
        for (int r = 0; r < ROW; r++) {
            dfs(r,0,pacific,heights[r][0],heights);
            dfs(r,COL-1,atlantic,heights[r][COL-1],heights);
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][] height){
        if(row<0 || col<0 || col>=COL || row>=ROW || visited[row][col] || height[row][col]<prevHeight)
            return;
        visited[row][col] = true;
        dfs(row+1,col,visited,height[row][col], height);
        dfs(row-1,col,visited,height[row][col], height);
        dfs(row,col+1,visited,height[row][col], height);
        dfs(row,col-1,visited,height[row][col], height);
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pa = new PacificAtlanticWaterFlow();
        int heights[][] = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pa.pacificAtlantic(heights));
    }
}
