package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new LinkedList<>();
        int firstListIterator=0, secondListIterator=0;
        while(firstListIterator<firstList.length && secondListIterator<secondList.length){
            int[] firstListElement = firstList[firstListIterator];
            int[] secondListElement = secondList[secondListIterator];
            int latestStart = Math.max(firstListElement[0], secondListElement[0]);
            int earliestEnd = Math.min(firstListElement[1], secondListElement[1]);
            if(earliestEnd>=latestStart)intersections.add(new int[] {latestStart,earliestEnd});
            if(firstListElement[1]<secondListElement[1])firstListIterator++;
            else secondListIterator++;
        }
        return intersections.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        IntervalListIntersections ii = new IntervalListIntersections();
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}}, secondList = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(ii.intervalIntersection(firstList,secondList)));
    }
}
