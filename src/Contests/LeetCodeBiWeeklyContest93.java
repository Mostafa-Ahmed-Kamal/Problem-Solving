package Contests;

import java.util.*;

public class LeetCodeBiWeeklyContest93 {
    public int maximumValue(String[] strs) {
        int maxLength = -1;
        for (String str: strs) {
            int value = 0;
            if(str.matches("[0-9]+")){
                value = Integer.parseInt(str);
            }
            else{
                value = str.length();
            }
            System.out.println("value = " + value);
            if(value > maxLength){
                maxLength = value;
            }
        }
        return maxLength;
    }

    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        PriorityQueue<Integer>[] graphsConnections = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            graphsConnections[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
        }
        for (int[] edge: edges) {
            graphsConnections[edge[0]].add(vals[edge[1]]);
            graphsConnections[edge[1]].add(vals[edge[0]]);
        }
        int maxSum = Integer.MIN_VALUE;
        int iterator = 0;
        for (PriorityQueue<Integer> list: graphsConnections){
            System.out.println(list);
            int currentSum = vals[iterator];
            iterator++;
            int end = Math.min(k,list.size());
            for (int i = 0; i < end; i++){
                int value = list.poll();
                if(value<0)break;
                currentSum+=value;
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
    private HashMap<Integer[], Integer> dp;
    public int maxJump(int[] stones) {
        dp = new HashMap<>();
        boolean[] marked = new boolean[stones.length];
        return maxJumpToEnd(stones, marked, 0, 0);
    }
    private int maxJumpToEnd(int[] stones, boolean[] marked, int position, int maxJump){
        int[] currentState = {position,maxJump};
        if(position == stones.length-1){
            int minMaxJump = Math.max(maxJump, maxJumpToStart(stones,marked));
            dp.put(new Integer[] {position,maxJump}, minMaxJump);
            return minMaxJump;
        }
        if(dp.containsKey(currentState)) return dp.get(currentState);
        int minMaxJump = Integer.MAX_VALUE;
        marked[position] = true;
        for (int i = position+1; i < stones.length; i++) {
            int currentJump = maxJumpToEnd(stones,marked,i,Math.max(maxJump,(stones[i]-stones[position])));
            minMaxJump = Math.min(minMaxJump,currentJump);
        }
        marked[position] = false;
        dp.put(new Integer[] {position,maxJump}, minMaxJump);
        return minMaxJump;
    }
    private int maxJumpToStart(int[] stones, boolean[] marked){
        int maxJump = 0;
        int currentPosition = stones[stones.length-1];
        for (int i = stones.length-2; i >= 0 ; i--) {
            if(!marked[i] || i==0){
                int currentJump = currentPosition - stones[i];
                currentPosition = stones[i];
                if(currentJump>maxJump){
                    maxJump = currentJump;
                }
            }
        }
        return maxJump;
    }

    public static void main(String[] args) {
        LeetCodeBiWeeklyContest93 lc93 = new LeetCodeBiWeeklyContest93();
        String[] strs = {"1","0a1","001","0001"};
        int vals[] = {1,2,3,4,10,-10,-20}, edges[][] = {{0,1},{1,2},{1,3},{3,4},{3,5},{3,6}}, k = 2;
//        System.out.println(lc93.maxStarSum(vals,edges,k));

        int[] stones = {0,2,5,6,7};
        System.out.println(lc93.maxJump(stones));
    }
}
