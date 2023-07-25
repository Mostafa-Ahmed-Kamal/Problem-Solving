package LeetCode;

public class PowXN {
    public double myPow(double x, int n) {
        long exponent = n;
        if (exponent<0){
            x = 1/x;
            exponent = -1*exponent;
        }
        double result = 1;
        double power = x;
        while(exponent>0){
            if (exponent%2==1) result *= power;
            power *= power;
            exponent/=2;
        }
        return result;
    }

}
