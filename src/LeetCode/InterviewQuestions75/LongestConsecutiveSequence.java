package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int maxCount = 1;
        int currentCount = 1;
        for (int num:set){
            if(!set.contains(num-1)){
                int currentNumber = num+1;
                currentCount = 1;
                while(set.contains(currentNumber)){
                    currentCount++;
                    currentNumber++;
                }
                maxCount = Math.max(maxCount,currentCount);
            }
        }
        return maxCount;
    }


    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int nums[] = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(lcs.longestConsecutive(nums));
    }
}
