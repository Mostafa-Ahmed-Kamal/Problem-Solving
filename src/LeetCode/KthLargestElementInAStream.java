package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    public static class KthLargest {
        PriorityQueue<Integer> priorityQueue;
        int k;
        public KthLargest(int k, int[] nums) {
            priorityQueue = new PriorityQueue<>();
            this.k = k;
            for (int num:nums)add(num);
        }

        public int add(int val) {
            priorityQueue.add(val);
            if (priorityQueue.size()>k)priorityQueue.poll();
            return priorityQueue.peek();
        }
    }
}
