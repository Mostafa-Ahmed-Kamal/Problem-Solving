package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++){
            if(newInterval[1]<intervals[i][0]){
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }
            else if(newInterval[0]>intervals[i][1]){
                result.add(intervals[i]);
            }
            else{
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
//        int intervals[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int newInterval[] = {4,8};
        int intervals[][] = {{1,3},{6,9}};
        int newInterval[] = {2,5};
        System.out.println(Arrays.deepToString(ii.insert(intervals,newInterval)));
    }
}
