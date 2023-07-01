package LeetCode;

import java.net.CacheRequest;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
    private class Candidate{
        int id;
        int costToHire;
        public Candidate(int id, int costToHire) {
            this.id = id;
            this.costToHire = costToHire;
        }
        public int getId() {
            return id;
        }
        public int getCostToHire() {
            return costToHire;
        }
    }
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Candidate> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Candidate::getCostToHire).thenComparingInt(Candidate::getId));
        int left=0,right=costs.length-1;
        for (int i = 0; i < candidates; i++) {
            if (left>right)break;
            priorityQueue.add(new Candidate(left,costs[left]));
            if (right!=left){
                priorityQueue.add(new Candidate(right,costs[right]));
                right--;
            }
            left++;
        }
        long cost = 0;
        while(!priorityQueue.isEmpty() && k>0){
            Candidate selectedCandidate = priorityQueue.poll();
            cost+= selectedCandidate.costToHire;
            if (left<=right) {
                if (selectedCandidate.id > right) {
                    priorityQueue.add(new Candidate(right,costs[right]));
                    right--;
                }
                else{
                    priorityQueue.add(new Candidate(left,costs[left]));
                    left++;
                }
            }
            k--;
        }
        return cost;
    }

    public static void main(String[] args) {
        TotalCostToHireKWorkers tw = new TotalCostToHireKWorkers();
        int costs[] = {17,12,10,2,7,2,11,20,8}, k = 3, candidates = 4;
        System.out.println(tw.totalCost(costs,k,candidates));
    }
}
