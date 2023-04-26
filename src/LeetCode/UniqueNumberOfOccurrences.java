package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> occurrences = new HashSet<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int currentVal = arr[i];
            int occurrenceCount = 0;
            while(i<arr.length && arr[i] == currentVal){
                occurrenceCount++;
                i++;
            }
            i--;
            if(occurrences.contains(occurrenceCount))return false;
            occurrences.add(occurrenceCount);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOfOccurrences uo = new UniqueNumberOfOccurrences();
        int[] arr = {1,2,3,2,4,3,3,4,4,4};
        System.out.println(uo.uniqueOccurrences(arr));
    }
}
