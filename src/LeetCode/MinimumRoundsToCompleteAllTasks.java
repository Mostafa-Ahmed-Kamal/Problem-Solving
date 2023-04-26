package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        int result = 0;
        HashMap<Integer,Integer> difficultyCount = new HashMap<>();
        for (int task:tasks){
            int count = difficultyCount.getOrDefault(task,0);
            difficultyCount.put(task,count+1);
        }
        for(Map.Entry<Integer,Integer> entry:difficultyCount.entrySet()){
            int minimumRoundsToCompleteADifficulty = minimumSplitOf3sAnd2s(entry.getValue());
            if(minimumRoundsToCompleteADifficulty==-1)return -1;
            result+=minimumRoundsToCompleteADifficulty;
        }
        return result;
    }
    private int minimumSplitOf3sAnd2s(int num){
        if(num<2)return -1;
        int possible3s = num/3;
        int remaining = num%3;
        return remaining==0?possible3s:possible3s+1;
    }

    public static void main(String[] args) {
        MinimumRoundsToCompleteAllTasks mt = new MinimumRoundsToCompleteAllTasks();
        int[] tasks = {2,2,2,3,3};
        System.out.println(mt.minimumRounds(tasks));
    }
}
