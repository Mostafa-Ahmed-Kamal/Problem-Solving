package LeetCode;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int n = pushed.length;
        int poppedIndex = 0;
        for (int element:pushed){
            while(!stack.isEmpty() && popped[poppedIndex]==stack.peek()){
                stack.pop();
                poppedIndex++;
            }
            stack.push(element);
        }
        while(!stack.isEmpty()){
            if (popped[poppedIndex]!=stack.pop())return false;
            poppedIndex++;
        }
        return poppedIndex==popped.length;
    }

    public static void main(String[] args) {
        ValidateStackSequences vss = new ValidateStackSequences();
        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
        System.out.println(vss.validateStackSequences(pushed,popped));
    }
}
