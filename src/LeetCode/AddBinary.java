package LeetCode;

public class AddBinary {
    public String addBinary(String a, String b) {
        int endA = a.length()-1, endB=b.length()-1;
        int carry = 0, sum=0;
        StringBuilder result = new StringBuilder();
        while(endA>=0 || endB>=0) {
            sum = carry;
            if(endA>=0)sum+=a.charAt(endA)-'0';
            if(endB>=0)sum+=b.charAt(endB)-'0';
            result.insert(0,sum%2);
            carry = sum/2;
            endA--;
            endB--;
        }
        if(carry==1)result.insert(0,carry);
        return result.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        String a = "11", b = "1";
        System.out.println(ab.addBinary(a,b));
    }
}
