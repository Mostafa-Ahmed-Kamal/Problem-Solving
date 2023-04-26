package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        int GenLength = start.length();
        int count=0;
        char availableChars[] = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> set = new HashSet<>(List.of(bank));
        queue.add(start);
        String currentGen;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for (int k = 0; k < queueSize; k++) {
                currentGen = queue.poll();
                if (visited.contains(currentGen)) continue;
                if (currentGen.equals(end)) return count;
                visited.add(currentGen);
                for (int i = 0; i < GenLength; i++) {
                    for (char availableChar : availableChars) {
                        String newGen = currentGen.substring(0, i) + availableChar + currentGen.substring(i + 1);
                        if (set.contains(newGen)) {
                            queue.add(newGen);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumGeneticMutation mgm = new MinimumGeneticMutation();
        String start = "AACCGGTT", end = "AACCGGTA", bank[] = {"AACCGGTA"};
        System.out.println(mgm.minMutation(start,end,bank));
    }
}
