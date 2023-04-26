package LeetCode;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> neededSums = new HashMap<>();
        neededSums.put(0,1);
        int count = 0;
        int prefixSum = 0;
        for (int num:nums) {
            prefixSum += num;
            // (n%k + k)%k deals with the negative numbers and gives the right mod to them;
            int remainder = (prefixSum%k + k)%k;
            int sumCount = neededSums.getOrDefault(remainder,0);
            count+= sumCount;
            neededSums.put(remainder,sumCount+1);
        }
        return count;
    }
    public static void main(String[] args) {
        SubarraySumsDivisibleByK ssk = new SubarraySumsDivisibleByK();
        int nums[] = { 4,5,0,-2,-3,1}, k = 5;
        System.out.println(ssk.subarraysDivByK(nums,k));
    }
}
