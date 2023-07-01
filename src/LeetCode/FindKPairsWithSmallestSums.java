package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0] + a[1]));
        for (int num1:nums1){
            for (int num2:nums2){
                priorityQueue.add(new Integer[]{num1,num2});
            }
        }
        while(!priorityQueue.isEmpty() && k>0){
            result.add(new LinkedList<>(List.of(priorityQueue.poll())));
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums fp = new FindKPairsWithSmallestSums();
        int nums1[] = {1,7,11}, nums2[] = {2,4,6}, k = 3;
        System.out.println(fp.kSmallestPairs(nums1,nums2,k));
    }
}
