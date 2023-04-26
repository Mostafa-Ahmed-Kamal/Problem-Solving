package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverLappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));
        if(intervals.length<2)return 0;
        if(intervals[0][1]>intervals[1][0]){
            return Math.min(eraseOverLapIntervalsRecursive(intervals,2,intervals[0],1),eraseOverLapIntervalsRecursive(intervals,2,intervals[1],1));
        }
        return eraseOverLapIntervalsRecursive(intervals,1,intervals[0],0);
    }

    private int eraseOverLapIntervalsRecursive(int[][] intervals, int index, int[] lastInterval, int count){
        if(index>=intervals.length) return count;
        if(lastInterval[1]>intervals[index][0]){
            return Math.min(eraseOverLapIntervalsRecursive(intervals,index+1,lastInterval,count+1),eraseOverLapIntervalsRecursive(intervals,index+1,intervals[index],count+1));
        }
        return eraseOverLapIntervalsRecursive(intervals,index+1,intervals[index],count);
    }

    public int betterSolution(int[][] intervals){
        if(intervals.length<2) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int lastInterval[] = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(lastInterval[1]>intervals[i][0]){
                lastInterval = (lastInterval[1]<intervals[i][1])? lastInterval:intervals[i];
                count++;
            }
            else{
                lastInterval = intervals[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NonOverLappingIntervals nolap = new NonOverLappingIntervals();
        int intervals[][] = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(nolap.eraseOverlapIntervals(intervals));
        System.out.println(nolap.betterSolution(intervals));
    }
}
