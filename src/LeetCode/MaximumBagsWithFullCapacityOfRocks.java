package LeetCode;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        for (int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int fullBags = 0;
        for(int leftCapacity:capacity){
            if(additionalRocks >= leftCapacity){
                fullBags++;
                additionalRocks -= leftCapacity;
            }
        }
        return fullBags;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacityOfRocks mb = new MaximumBagsWithFullCapacityOfRocks();
        int capacity[] = {2,3,4,5}, rocks[] = {1,2,4,4}, additionalRocks = 2;
        System.out.println(mb.maximumBags(capacity,rocks,additionalRocks));
    }
}
