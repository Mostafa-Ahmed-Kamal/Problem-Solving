package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        int[] appearance = new int[26];
        Arrays.fill(appearance,-1);
        int partitionCount = 1;
        int subStringStart = 0;
        for (int i=0 ; i<s.length(); i++){
            char c = s.charAt(i);
            if (appearance[c-'a']>=subStringStart){
                partitionCount++;
                subStringStart = i;
            }
            appearance[c-'a']=i;
        }
        return partitionCount;
    }
    public int betterSolution(String s){
        int appearances = 0; /// we can represent the 26 characters as 1 bit each
        int partitionCount = 1;
        for (char c:s.toCharArray()){
            int charRepresentation = 1 << (c-'a');
            if((appearances & charRepresentation) != 0){
                partitionCount++;
                appearances=0;
            }
            appearances |= charRepresentation;
        }
        return partitionCount;
    }

}
