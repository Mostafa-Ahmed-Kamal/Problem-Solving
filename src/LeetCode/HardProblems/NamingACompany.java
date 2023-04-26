package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NamingACompany {
    public long distinctNames(String[] ideas) {
        long result = 0;
        int n = ideas.length;
        HashSet<String>[] ideasByFirstLetter = new HashSet[26];
        for (int i=0; i<26; i++){
            ideasByFirstLetter[i] = new HashSet<>();
        }
        for (String idea:ideas){
            char firstLetter = idea.charAt(0);
            ideasByFirstLetter[firstLetter-'a'].add(idea.substring(1));
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if(i==j)continue;
                int commonIdeasCount = 0;
                for (String idea:ideasByFirstLetter[i]){
                    if(ideasByFirstLetter[j].contains(idea)){
                        commonIdeasCount++;
                    }
                }
                int uniqueIdeasI = ideasByFirstLetter[i].size()-commonIdeasCount;
                int uniqueIdeasJ = ideasByFirstLetter[j].size()-commonIdeasCount;
                result += (long) uniqueIdeasI*uniqueIdeasJ;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NamingACompany nc = new NamingACompany();
        String[] ideas = {"coffee","donuts","time","toffee"};
        System.out.println(nc.distinctNames(ideas));
    }
}
