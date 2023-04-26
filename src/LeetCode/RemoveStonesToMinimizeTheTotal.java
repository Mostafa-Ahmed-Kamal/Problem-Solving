package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int result = 0;
        for (int pile:piles){
            result += pile;
            priorityQueue.add(pile);
        }
        System.out.println(priorityQueue);
        for(int i=0; i<k; i++){
            int heaviestPile = priorityQueue.poll();
            int removedStones = heaviestPile/2;
            result-=removedStones;
            priorityQueue.add(heaviestPile-removedStones);
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal rs = new RemoveStonesToMinimizeTheTotal();
        int piles[] = {5,4,9}, k = 2;
        System.out.println(rs.minStoneSum(piles,k));
    }
}
