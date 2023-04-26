package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new LinkedList<>();
        int carry = 0;
        int numEnd = num.length-1;
        while(k>0 || numEnd>=0){
            int kDigit = k>0? k%10:0;
            int numDigit = numEnd>=0? num[numEnd]:0;
            int sum = numDigit + kDigit + carry;
            result.add(0,sum%10);
            carry = sum/10;
            k/=10;
            numEnd--;
        }
        if(carry>0)result.add(0,carry);
        return result;
    }

    public static void main(String[] args) {
        AddToArrayFormOfInteger aa = new AddToArrayFormOfInteger();
            int num[] = {2,7,4}, k = 181;
        System.out.println(aa.addToArrayForm(num,k));
    }
}
