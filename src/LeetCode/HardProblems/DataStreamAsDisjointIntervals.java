package LeetCode.HardProblems;

import java.util.*;

public class DataStreamAsDisjointIntervals {
    public static class SummaryRanges {
        SortedSet<Integer> sortedSet;
        public SummaryRanges() {
            sortedSet = new TreeSet<>();
        }

        public void addNum(int value) {
            sortedSet.add(value);
        }

        public int[][] getIntervals() {
            List<int[]> result = new LinkedList<>();
            int start = sortedSet.first();
            int end = sortedSet.first();
            for (int value:sortedSet){
                if(end==value || end==value-1){
                    end = value;
                }
                else {
                    result.add(new int[]{start, end});
                    start = end = value;
                }
            }
            result.add(new int[] {start,end});
            return result.toArray(new int[0][0]);
        }
    }

    public static void main(String[] args) {
        SummaryRanges sm = new SummaryRanges();
        sm.addNum(1);
        sm.addNum(3);
        sm.addNum(7);
        sm.addNum(2);
        sm.addNum(5);
        System.out.println(Arrays.deepToString(sm.getIntervals()));

    }
}
