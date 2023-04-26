package LeetCode.HardProblems;

import java.util.Arrays;

public class ReducingDishes {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        int currentSum=0;
        int propagatedMax=0;
        for (int start = satisfaction.length-1; start >= 0; start--) {
            currentSum+=satisfaction[start];
            propagatedMax+=currentSum;
            max = Math.max(max,propagatedMax);
        }
        return max;
    }

    public static void main(String[] args) {
        ReducingDishes rd = new ReducingDishes();
        int[] satisfaction = {-1,-8,0,5,-9};
        System.out.println(rd.maxSatisfaction(satisfaction));
    }
}
