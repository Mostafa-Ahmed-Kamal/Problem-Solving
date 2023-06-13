package LeetCode;

public class MinimumFlipsToMakeAORBEqualtoC {
    public int minFlips(int a, int b, int c) {
        int minFlips = 0;
        while(a>0 || b>0 || c>0){
            int bitA = a%2, bitB = b%2, bitC=c%2;
            a = a/2; b = b/2; c = c/2;
            if ((bitA | bitB) == bitC)continue;
            if (bitC==1)minFlips++;
            else minFlips += (bitA==0?0:1) + (bitB==0?0:1);

        }
        return minFlips;
    }

    public static void main(String[] args) {
        MinimumFlipsToMakeAORBEqualtoC mabc = new MinimumFlipsToMakeAORBEqualtoC();
        int a = 4, b = 2, c = 7;
        System.out.println(mabc.minFlips(a,b,c));
    }
}
