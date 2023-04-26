package LeetCode.InterviewQuestions75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combination = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSumRecursive(candidates, target, combination, 0);
        return result;
    }

    public void combinationSumRecursive(int[] candidates, int target, List<Integer> combination, int start){
        if (target==0){
            result.add(combination);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i]<=target){
                List<Integer> newComb = new LinkedList<>(combination);
                newComb.add(candidates[i]);
                combinationSumRecursive(candidates, target-candidates[i], newComb, i);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int candidates[] = {2,3,6,7};
        System.out.println(cs.combinationSum(candidates, 7));
    }
}
