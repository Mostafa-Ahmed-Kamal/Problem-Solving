package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Dota2Senate {
        public String predictPartyVictory(String senate) {
            Queue<Integer> radiantIndices = new LinkedList<>();
            Queue<Integer> direIndices = new LinkedList<>();
            int n = senate.length();
            for (int i=0; i<n; i++){
                char c = senate.charAt(i);
                if(c=='R') radiantIndices.add(i);
                else if(c=='D')direIndices.add(i);
            }
            while(!radiantIndices.isEmpty() && !direIndices.isEmpty()){
                int radiantIndex = radiantIndices.poll();
                int direIndex = direIndices.poll();
                if(radiantIndex < direIndex)radiantIndices.add(radiantIndex+n);
                else direIndices.add(direIndex+n);
            }
            return radiantIndices.size()>direIndices.size()?"Radiant":"Dire";
        }

    public static void main(String[] args) {
        Dota2Senate d2s = new Dota2Senate();
        String senate = "RDD";
        System.out.println(d2s.predictPartyVictory(senate));
    }
}
