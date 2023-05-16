package LeetCode;

import java.util.HashMap;

public class CountWaysToBuildGoodStrings {
    HashMap<Integer,Integer> visited;
    private final double MOD = Math.pow(10,9)+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        visited = new HashMap();
        return dp(low,high,0,zero,one);
    }
    public int dp(int low, int high, int length, int zero, int one){
        if (length>high)return 0;
        if (length==high)return 1;
        if (visited.containsKey(length))return visited.get(length);
        double count = (length<low?0:1) + dp(low,high,length+zero,zero,one) + dp(low,high,length+one,zero,one);
        visited.put(length,(int)(count%MOD));
        return (int)(count%MOD);
    }

    public static void main(String[] args) {
        CountWaysToBuildGoodStrings cw = new CountWaysToBuildGoodStrings();
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(cw.countGoodStrings(low,high,zero,one));
    }
}
