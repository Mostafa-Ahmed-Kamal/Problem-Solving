package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class MaximumNumberOfEventsThatCanBeAttendedII {
    HashMap<Integer,Integer>[] dp;
    public int maxValue(int[][] events, int k) {
        dp = new HashMap[k+1];
        for (int i = 0; i < k+1; i++) {
            dp[i] = new HashMap<>();
        }
        Arrays.sort(events, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt((int[] a) -> a[1]));
        return maxValueDP(events,k,0);
    }
    public int maxValueDP(int[][] events, int k, int start){
        if (start>=events.length || k<=0)return 0;
        if (dp[k].containsKey(start))return dp[k].get(start);
        int leaveEvent = maxValueDP(events,k,start+1);
        int nextEvent = nextEvent(events,events[start][1],start,events.length);
        int takeEvent = events[start][2] + maxValueDP(events,k-1,nextEvent);
        int result = Math.max(leaveEvent,takeEvent);
        dp[k].put(start,result);
        return result;
    }
    private int nextEvent(int[][] events, int target, int start, int end){
        if (start>=end)return start;
        int mid = start + (end-start)/2;
        if (events[mid][0]<=target)return nextEvent(events,target,mid+1,end);
        return nextEvent(events,target,start,mid);
    }

    public static void main(String[] args) {
        MaximumNumberOfEventsThatCanBeAttendedII me2 = new MaximumNumberOfEventsThatCanBeAttendedII();
        int events[][] = {{1,2,4},{3,4,3},{2,3,10}}, k = 2;
        System.out.println(me2.maxValue(events,k));
    }
}
