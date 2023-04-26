package LeetCode;

import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        boolean[] definitelyNotJudge = new boolean[n+1];
        int[] trustCount = new int[n+1];
        for (int[] trustEdge:trust){
            definitelyNotJudge[trustEdge[0]] = true;
            trustCount[trustEdge[1]]++;
        }
        for (int i=1; i<n+1; i++){
            if(!definitelyNotJudge[i] && trustCount[i]==n-1)return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge ftj = new FindTheTownJudge();
        int n = 2, trust[][] = {{1,2}};
        System.out.println(ftj.findJudge(n,trust));
    }
}
