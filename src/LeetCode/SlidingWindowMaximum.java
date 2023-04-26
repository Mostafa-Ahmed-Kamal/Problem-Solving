package LeetCode;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int outputSize = nums.length - k + 1;
        int[] output = new int[outputSize];
        for (int i = 0; i < outputSize; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }
    private void addToQueue(Deque<Integer> queue, int index, int[] nums){
        while(!queue.isEmpty() && nums[index] > nums[queue.peekLast()]){
            queue.pollLast();
        }
        queue.add(index);
    }
    // monotonically increasing queue
    public int[] betterSolution(int[] nums, int k){
        int outputSize = nums.length - k + 1;
        int[] output = new int[outputSize];
        int outputIterator = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k-1; i++) {
            addToQueue(queue,i,nums);
        }
        for (int i=k-1; i<nums.length; i++){
            while(!queue.isEmpty() && queue.peek() < i-k+1){
                queue.poll();
            }
            addToQueue(queue,i,nums);
            output[outputIterator] = nums[queue.peek()];
            outputIterator++;
        }
        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum sm = new SlidingWindowMaximum();
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        System.out.println(Arrays.toString(sm.maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(sm.betterSolution(nums, k)));
    }
}
