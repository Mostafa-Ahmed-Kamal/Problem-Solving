package LeetCode;

public class UglyNumber {

    public boolean isUgly(int n) {
        int primes[] = {2,3,5};
        boolean more = false;
        while(n!=1){
            more=false;
            for(int prime:primes){
                if(n%prime==0){
                    n/=prime;
                    more=true;
                }
            }
            if(!more)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        UglyNumber un = new UglyNumber();
        System.out.println(un.isUgly(-2147483648));
    }
}
