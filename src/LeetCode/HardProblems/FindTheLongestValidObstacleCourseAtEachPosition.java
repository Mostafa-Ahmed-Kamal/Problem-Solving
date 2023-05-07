package LeetCode.HardProblems;

import java.util.Arrays;

public class FindTheLongestValidObstacleCourseAtEachPosition {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int arrayLength = 0;
        int[] longestIncreasingSubSequence = new int[obstacles.length];
        int[] longestObstacleCourse = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            int closestValidObstacle = binarySearch(longestIncreasingSubSequence,0,arrayLength,obstacles[i]);
            if (closestValidObstacle==arrayLength){
                arrayLength++;
            }
            longestIncreasingSubSequence[closestValidObstacle] = obstacles[i];
            longestObstacleCourse[i] = closestValidObstacle+1;
        }
        return longestObstacleCourse;
    }
    private int binarySearch(int[] longestIncreasingSubSequence, int start, int end, int maxValue){
        if(start>=end)return start;
        int mid = (start+end)/2;
        if (longestIncreasingSubSequence[mid]>maxValue)return binarySearch(longestIncreasingSubSequence, start,mid,maxValue);
        else return binarySearch(longestIncreasingSubSequence,mid+1,end,maxValue);
    }

    public static void main(String[] args) {
        FindTheLongestValidObstacleCourseAtEachPosition f = new FindTheLongestValidObstacleCourseAtEachPosition();
        int[] obstacles = {3,1,5,6,4,2};
        System.out.println(Arrays.toString(f.longestObstacleCourseAtEachPosition(obstacles)));
    }
}
