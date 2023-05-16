package LeetCode.Utils;

public class EuclideanGCD {
    public int gcd(int x, int y){
        if(y==0)return x;
        return gcd(y,x%y);
    }

}

