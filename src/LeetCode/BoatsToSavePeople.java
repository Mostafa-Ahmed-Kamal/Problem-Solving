package LeetCode;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start=0, end=people.length-1;
        int boatsCount=0;
        while(start<=end){
            if(people[start]+people[end]<=limit){
                start++;
            }
            end--;
            boatsCount++;
        }
        return boatsCount;
    }

    public static void main(String[] args) {
        BoatsToSavePeople bsp = new BoatsToSavePeople();
        int people[] = {1,2}, limit = 3;
        System.out.println(bsp.numRescueBoats(people,limit));
    }
}
