package LeetCode.InterviewQuestions75;

import java.util.*;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        System.out.println(map);
        List<Map.Entry<Integer,Integer>> sortedList = new LinkedList<>(map.entrySet());
        Collections.sort(sortedList,Map.Entry.comparingByValue());
        Collections.reverse(sortedList);
        System.out.println(sortedList);
        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = sortedList.get(i).getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements tfe = new TopKFrequentElements();
        int nums[] = {1,1,1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(tfe.topKFrequent(nums,k)));
    }

}
