package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class MostStonesRemovedWithSameRowOrColumn {
    HashSet<int[]> visited;
    public int removeStones(int[][] stones) {
        int count = stones.length;
        visited = new HashSet<>();
        for (int[] stone:stones){
            if(!visited.contains(stone)){
                dfs(stones,stone);
                count--;
            }
        }
        return count;
    }
    private void dfs(int[][] stones,int[] stoneLocation){
       visited.add(stoneLocation);
       for (int[] stone:stones){
           if(!visited.contains(stone) && (stone[0]==stoneLocation[0] || stone[1]==stoneLocation[1])){
               dfs(stones,stone);
           }
       }
    }

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn msc = new MostStonesRemovedWithSameRowOrColumn();
        int stones[][] = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(msc.removeStones(stones));
    }

}
