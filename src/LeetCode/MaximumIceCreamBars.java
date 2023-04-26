package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        for (int i=0 ;i<n;i++){
            if((coins-=costs[i])<0){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        MaximumIceCreamBars mib=  new MaximumIceCreamBars();
        int costs[] = {1,3,2,4,1}, coins = 7;
        System.out.println(mib.maxIceCream(costs,coins));
    }
}
