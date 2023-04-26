package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class NumberOfBurgersWithNoWasteOfIngredients {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int smallBurgers = binarySearch(0,cheeseSlices,tomatoSlices,cheeseSlices);
        if (smallBurgers==-1)return new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        result.add(cheeseSlices-smallBurgers);
        result.add(smallBurgers);
        return result;
    }
    private int binarySearch(int min, int max, int tomatoSlices, int cheeseSlices){
        if (min>max)return -1;
        int mid = (min+max)/2;
        int tomatoLeft = tomatoSlices - (mid*2 + (cheeseSlices-mid)*4);
        if (tomatoLeft==0)return mid;
        if (tomatoLeft<0)return binarySearch(mid+1,max,tomatoSlices,cheeseSlices);
        return binarySearch(min,mid-1,tomatoSlices,cheeseSlices);
    }
    public List<Integer> betterSolution(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices%2==1 || cheeseSlices*2>tomatoSlices)return new LinkedList<>();
        int largeBurgers = (tomatoSlices-cheeseSlices)/2;
        int smallBurgers = cheeseSlices-largeBurgers;
        List<Integer> result = new LinkedList<>();
        result.add(largeBurgers);
        result.add(smallBurgers);
        return largeBurgers>0 && smallBurgers>0?result:new LinkedList<>();
    }
}

