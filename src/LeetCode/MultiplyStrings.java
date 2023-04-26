package LeetCode;

import java.util.Arrays;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 */
public class MultiplyStrings {
    public String sum(String num1, String num2){

        if(num1.isEmpty())return num2;
        else if(num2.isEmpty())return num1;

        StringBuilder output = new StringBuilder();
        int diff = num1.length() - num2.length();
        int carry = 0, sum, digit1, digit2;
        if(diff>0) num2 = "0".repeat(diff) + num2;
        else if(diff<0) num1 = "0".repeat(-diff) + num1;


        for (int i = num1.length()-1; i >=0 ; i--) {
            digit1 = num1.charAt(i)-48;
            digit2 = num2.charAt(i)-48;
            sum = digit1 + digit2 + carry;
            carry = sum/10;
            output.insert(0,sum%10);
        }
        if(carry>0)output.insert(0,carry);
        return output.toString();
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))return "0";
        StringBuilder result = new StringBuilder();
        String output = "";
        int carry = 0;
        int sum=0;
        for (int i = num1.length()-1; i>=0 ; i--) {
            for (int j = num2.length()-1; j >=0 ; j--) {
                sum = (num1.charAt(i)-48)*(num2.charAt(j)-48) + carry;
                carry = sum/10;
                result.insert(0,sum%10);
            }
            result.append("0".repeat(num1.length()-1-i));
            if(carry>0)result.insert(0,carry);
            output = sum(output,result.toString());
            result.delete(0,result.length());
            carry=0;
        }


        return output.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("123","456")); // 56088
        System.out.println(ms.multiply("123","0")); // 56088
    }
}
