package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {entrance[0]-1,entrance[1]});
        queue.add(new int[] {entrance[0]+1,entrance[1]});
        queue.add(new int[] {entrance[0],entrance[1]-1});
        queue.add(new int[] {entrance[0],entrance[1]+1});
        visited[entrance[0]][entrance[1]] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            count++;
            for (int i = 0; i < queueSize; i++) {
                int position[] = queue.poll();
                if(isValidPoint(visited, position, maze)){
                    if(isExit(position,maze))return count;
                    visited[position[0]][position[1]]=true;
                    queue.add(new int[] {position[0]-1,position[1]});
                    queue.add(new int[] {position[0]+1,position[1]});
                    queue.add(new int[] {position[0],position[1]-1});
                    queue.add(new int[] {position[0],position[1]+1});
                }
            }
        }
        return -1;
    }
    private boolean isValidPoint(boolean[][] visited, int position[], char[][] maze){
        int row = position[0], col= position[1];
        return !(row<0 || row>=maze.length || col<0 || col>=maze[0].length ||
                visited[row][col] || maze[row][col]=='+');
    }
    private boolean isExit(int position[], char[][] maze){
        int row=position[0], col=position[1];
        return row==0 || row==maze.length-1 || col==0 || col==maze[0].length-1;
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze ne = new NearestExitFromEntranceInMaze();
        char maze[][] = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int entrance[] = {0,2};
        System.out.println(ne.nearestExit(maze,entrance));
    }
}
