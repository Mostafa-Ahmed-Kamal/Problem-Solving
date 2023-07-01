package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.HashMap;

public class CountAllPossibleRoutes {
    private final double MOD = Math.pow(10,9)+7;
    // currentLocation --> Fuel
    HashMap<Integer,HashMap<Integer,Integer>> dp;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new HashMap<>();
        return (int)countRoutesDP(locations,start,finish,fuel);
    }
    private double countRoutesDP(int[] locations, int currentLocation, int finish, int fuel){
        int distanceFromCurrentToFinish = Math.abs(locations[currentLocation]-locations[finish]);
        if (distanceFromCurrentToFinish>fuel)return 0;
        if (dp.containsKey(currentLocation) && dp.get(currentLocation).containsKey(fuel))return dp.get(currentLocation).get(fuel);
        double count = currentLocation==finish?1:0;
        for (int i=0; i<locations.length; i++) {
            int location = locations[i];
            if (i==currentLocation)continue;
            int distance = Math.abs(location-locations[currentLocation]);
            if (distance>fuel)continue;
            count = (count + countRoutesDP(locations,i,finish,fuel-distance))%MOD;
        }
        count%=MOD;
        dp.putIfAbsent(currentLocation, new HashMap<>());
        dp.get(currentLocation).put(fuel,(int)count);
        return count;
    }

    public static void main(String[] args) {
        CountAllPossibleRoutes car = new CountAllPossibleRoutes();
        int locations[] = {4,3,1}, start = 1, finish = 0, fuel = 6;
        System.out.println(car.countRoutes(locations,start,finish,fuel));
    }
}
