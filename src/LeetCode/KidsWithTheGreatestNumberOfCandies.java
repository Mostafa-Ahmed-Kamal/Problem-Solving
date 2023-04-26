package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candie:candies){
            max = Math.max(max,candie);
        }
        List<Boolean> kidsWithMaxCandies = new LinkedList<>();
        for (int candie:candies){
            kidsWithMaxCandies.add(candie+extraCandies>=max);
        }
        return kidsWithMaxCandies;
    }
}
