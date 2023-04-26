package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone:stones){
            priorityQueue.add(stone);
        }
        while(priorityQueue.size()>1){
            int largestStone = priorityQueue.poll();
            int secondLargestStone = priorityQueue.poll();
            largestStone -= secondLargestStone;
            if (largestStone>0)priorityQueue.add(largestStone);
        }
        return priorityQueue.size()==0?0:priorityQueue.poll();
    }
}
