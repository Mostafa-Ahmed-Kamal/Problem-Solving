package LeetCode;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches){
        HashMap<Integer,Integer> playersLoses = new HashMap<>();
        for (int[] match: matches){
            int winnerId = match[0];
            int loserId = match[1];
            if(!playersLoses.containsKey(winnerId)){
                playersLoses.put(winnerId,0);
            }
            playersLoses.put(loserId,playersLoses.getOrDefault(loserId,0)+1);
        }
        List<Integer> zeroLoss = new LinkedList<>();
        List<Integer> oneLoss = new LinkedList<>();
        for (Map.Entry<Integer,Integer> entry:playersLoses.entrySet()){
            if(entry.getValue()==0){
                zeroLoss.add(entry.getKey());
            }
            else if(entry.getValue()==1){
                oneLoss.add(entry.getKey());
            }
        }
        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);
        List<List<Integer>> result = new LinkedList<>();
        result.add(zeroLoss);
        result.add(oneLoss);
        return result;
    }

    public static void main(String[] args) {
        FindPlayersWithZeroOrOneLosses fp = new FindPlayersWithZeroOrOneLosses();
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(fp.findWinners(matches));
    }
}
