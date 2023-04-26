package LeetCode.InterviewQuestions75;
/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(b!=0){
            int temp=a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers si = new SumOfTwoIntegers();
        System.out.println(si.getSum(20,20));
    }
}

