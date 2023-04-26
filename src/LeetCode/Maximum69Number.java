package LeetCode;

import java.util.Arrays;

public class Maximum69Number {
    public int maximum69Number (int num) {
        int power = 0;
        int biggest6Index = -1;
        while(Math.pow(10,power)<num){
            int n = (int) (num/Math.pow(10,power)%10);
            if(n==6)biggest6Index=power;
            power++;
        }
        return biggest6Index==-1? num: (int) (num + 3 * Math.pow(10, biggest6Index));
    }

    public static void main(String[] args) {
        Maximum69Number mn = new Maximum69Number();
        int num = 999666;
        System.out.println(mn.maximum69Number(num));
    }
}
