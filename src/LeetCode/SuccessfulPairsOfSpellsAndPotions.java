package LeetCode;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] successfulPairs = new int[spells.length];
        for (int i = 0; i < successfulPairs.length; i++) {
            int spell = spells[i];
            if (success>(long) spell*potions[potions.length-1])continue;
            successfulPairs[i] = potions.length-binarySearch(potions,success,spell,0,potions.length-1);
        }
        return successfulPairs;
    }
    private int binarySearch(int[] potions, long success, int spell, int start, int end){
        if(start>=end) return start;
        int mid = (start+end)/2;
        long spellPotion = (long) spell*potions[mid];
        if (spellPotion<success)return binarySearch(potions,success,spell,mid+1,end);
        return binarySearch(potions,success,spell,start,mid);
    }

    public static void main(String[] args) {
        SuccessfulPairsOfSpellsAndPotions sps = new SuccessfulPairsOfSpellsAndPotions();
        int[] spells = {5,1,3}, potions = {1,2,3,4,5};
        int success = 7;
        System.out.println(Arrays.toString(sps.successfulPairs(spells,potions,success)));
    }
}
