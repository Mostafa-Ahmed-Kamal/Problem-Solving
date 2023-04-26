package LeetCode.HardProblems;

public class RestoreTheArray {
    double[] dp;
    double MOD = Math.pow(10,9)+7;
    public int numberOfArrays(String s, int k) {
        dp = new double[s.length()];
        return (int)(numberOfArraysRecursive(s,k,0)%MOD);
    }
    private double numberOfArraysRecursive(String s, int k, int startingIndex){
        if(startingIndex>=s.length())return 1;
        if(s.charAt(startingIndex)=='0')return 0;
        if (dp[startingIndex]!=0)return dp[startingIndex]%MOD;
        long value = 0;
        int iterator = startingIndex;
        while(iterator<s.length()){
            value=value*10+(s.charAt(iterator) - '0');
            if (value>k)break;
            iterator++;
            dp[startingIndex] = (dp[startingIndex]%MOD + numberOfArraysRecursive(s,k,iterator)%MOD)%MOD;
        }
        return dp[startingIndex]%MOD;
    }

    public static void main(String[] args) {
        RestoreTheArray ra = new RestoreTheArray();
        String s = "1000";
        int k = 10;
        System.out.println(ra.numberOfArrays(s,k));

    }
}
