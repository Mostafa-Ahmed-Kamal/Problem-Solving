package LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet {
    class SmallestInfiniteSet {
        int smallestContinuousInt;
        PriorityQueue<Integer> priorityQueue;
        HashSet<Integer> numbersInQueue;
        public SmallestInfiniteSet() {
            smallestContinuousInt = 1;
            priorityQueue = new PriorityQueue<>();
            numbersInQueue = new HashSet<>();
        }

        public int popSmallest() {
            if (!priorityQueue.isEmpty() && priorityQueue.peek()<smallestContinuousInt){
                int smallestNum = priorityQueue.poll();
                numbersInQueue.remove(smallestNum);
                return smallestNum;
            }
            smallestContinuousInt++;
            return smallestContinuousInt-1;
        }

        public void addBack(int num) {
            if (num>=smallestContinuousInt || numbersInQueue.contains(num))return;
            if (smallestContinuousInt-num==1) {
                smallestContinuousInt--;
                return;
            }
            numbersInQueue.add(num);
            priorityQueue.add(num);
        }
    }
}
