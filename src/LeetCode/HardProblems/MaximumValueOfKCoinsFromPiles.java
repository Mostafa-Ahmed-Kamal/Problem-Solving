package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MaximumValueOfKCoinsFromPiles {
    int[][] memoaization;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        memoaization = new int[piles.size()+1][k+1];
        int[] stackPointers = new int[piles.size()];
        return maxValueDp(stackPointers,piles,k,0);
    }
    private int maxValueDp(int[] stackPointers, List<List<Integer>> piles, int k, int maxValue){
        if (k<=0)return maxValue;
        int max = 0;
        for (int i=0; i<stackPointers.length; i++){
            if (stackPointers[i] >= piles.get(i).size())continue;
            stackPointers[i]++;
            max = Math.max(max,maxValueDp(stackPointers,piles,k-1,maxValue+piles.get(i).get(stackPointers[i]-1)));
            stackPointers[i]--;
        }
        return max;
    }
}
