package LeetCode.HardProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeDeviationInArray {
    private class QueueInfo {
        int n,maxN;
        public QueueInfo(int n, int maxN){
            this.n = n;
            this.maxN = maxN;
        }
        public int getN(){
            return n;
        }
    }
    public int minimumDeviation(int[] nums) {
        PriorityQueue<QueueInfo> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(QueueInfo::getN));
        int arraySize = nums.length;
        int maxValue=0, minimumDifference=Integer.MAX_VALUE;
        for (int num:nums){
            int maxN = num%2==0? num : num*2;
            while(num%2==0){
                num /= 2;
            }
            maxValue = Math.max(maxValue,num);
            priorityQueue.add(new QueueInfo(num,maxN));
        }

        while(priorityQueue.size()==arraySize){
            QueueInfo minElement = priorityQueue.poll();
            minimumDifference = Math.min(minimumDifference,maxValue-minElement.n);
            if(minElement.n<minElement.maxN) {
                minElement.n *= 2;
                maxValue = Math.max(maxValue,minElement.n);
                priorityQueue.add(minElement);
            }
        }
        return minimumDifference;
    }

    public static void main(String[] args) {
        MinimizeDeviationInArray ma = new MinimizeDeviationInArray();
        int[] nums = {3,5};
        System.out.println(ma.minimumDeviation(nums));
    }
}
