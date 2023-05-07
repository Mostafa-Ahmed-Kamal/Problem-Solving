package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num:nums1){
            set1.add(num);
        }
        for (int num:nums2){
            set2.add(num);
        }
        List<Integer> distinctNum1 = new ArrayList<>(set1);
        distinctNum1.removeAll(set2);
        List<Integer> distinctNum2 = new ArrayList<>(set2);
        distinctNum2.removeAll(set1);
        return new LinkedList<>(Arrays.asList(distinctNum1,distinctNum2));
    }

    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays fd = new FindTheDifferenceOfTwoArrays();
        int[] nums1 = {1,2,3,3}, nums2 = {1,1,2,2};
        System.out.println(fd.findDifference(nums1,nums2));
    }
}
