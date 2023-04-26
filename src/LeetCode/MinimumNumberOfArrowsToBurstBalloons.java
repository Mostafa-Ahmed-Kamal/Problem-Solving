package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        int arrowCount = 1;
        int maxEnd = points[0][1];
        for (int[] point:points) {
            if(maxEnd<point[0]){
                arrowCount++;
                maxEnd = point[1];
            }
            if(point[1]<maxEnd)
                maxEnd = point[1];
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons mb = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(mb.findMinArrowShots(points));
    }
}
