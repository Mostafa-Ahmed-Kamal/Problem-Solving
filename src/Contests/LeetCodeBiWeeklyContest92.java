package Contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCodeBiWeeklyContest92 {
    public int numberOfCuts(int n) {
        if(n<2) return 0;
        if(n%2==0)return n/2;
        return n;
    }
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] CountRows = new int[n];
        int[] CountCols = new int[m];
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = grid[i][j]==0?-1:1;
                CountRows[i]+=value;
                CountCols[j]+=value;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = CountRows[i]+ CountCols[j];
            }
        }
        return result;
    }

    public int bestClosingTime(String customers) {
        int n = customers.length();
        int currentMin = 0;
        // if always open
        char[] times = customers.toCharArray();
        for (char c:times){
            if(c=='N')currentMin++;
        }
        int min = currentMin;
        int timeToClose = n;
        for (int i = times.length-1; i >=0 ; i--) {
            int addition = times[i]=='Y'?1:-1;
            currentMin+=addition;
            if(currentMin<=min){
                min = currentMin;
                timeToClose = i;
            }
        }
        System.out.println(currentMin);
        return timeToClose;
    }
    private class mapInfo{
        int left;
        int right;
        // remaining numbers for 5;
        int count;
        public mapInfo(int left, int right, int count){
            this.left = left;
            this.right = right;
            this.count = count;
        }
    }
    HashMap<mapInfo,Integer> visited = new HashMap<>();
    public int countPalindromes(String s) {
        int count =0;
        for (int start = 0; start < s.length()-5; start++) {
            for (int end = start+5; end < s.length(); end++) {
                count+=getPalindromes(start,end,0,s);
            }
        }
        return count;
    }
    // is palindrome of length 5?
    public int getPalindromes(int start, int end, int count, String s){
        if(end<start) return 0;
        if(count==2) {
            int possibilities = end-start+1;
            visited.put(new mapInfo(start,end,count),possibilities);
            return possibilities;
        }
        mapInfo mapInfo = new mapInfo(start,end,count);
        if(visited.containsKey(mapInfo))
            return visited.get(mapInfo);
        if(s.charAt(start)==s.charAt(end)){
            return getPalindromes(start+1,end-1,count+1,s);
        }
        return Math.max(getPalindromes(start+1,end,count,s),getPalindromes(start,end-1,count,s));
    }

    public static void main(String[] args) {
        LeetCodeBiWeeklyContest92 lc92 = new LeetCodeBiWeeklyContest92();
        int[][] grid = {{0,1,1},
                        {1,0,1},
                        {0,0,1}};
//        System.out.println(Arrays.deepToString(lc92.onesMinusZeros(grid)));
//        System.out.println(lc92.bestClosingTime("NNNNN"));
        //3+2+2+
        System.out.println(lc92.countPalindromes("0000000"));
    }
}
