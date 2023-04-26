package LeetCode.InterviewQuestions75;
import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals.length<2)return intervals;
        Arrays.sort(intervals , Comparator.comparingInt(a -> a[0]));
        Stack<int[]> result = new Stack<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(result.peek()[1]>=intervals[i][0]){
                result.peek()[0] = Math.min(result.peek()[0],intervals[i][0]);
                result.peek()[1] = Math.max(result.peek()[1],intervals[i][1]);
            }
            else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        int intervals[][] = {{1,4},{0,0}};
        System.out.println(Arrays.deepToString(mi.merge(intervals)));
    }
}
