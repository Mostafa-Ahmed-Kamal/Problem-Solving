package LeetCode.InterviewQuestions75;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n>>i&1;
            result|= bit<<(31-i);
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(4));
    }
}
