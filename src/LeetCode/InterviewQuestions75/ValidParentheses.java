package LeetCode.InterviewQuestions75;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        /** {} [] () **/
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if(c=='{' || c=='[' || c=='(')
                stack.add(c);
            else if(stack.isEmpty())return false;
            else{
                char openBracket = stack.pop();
                if((openBracket=='(' && c!=')') || (openBracket=='[' && c!=']') || (openBracket=='{' && c!='}'))return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([)]"));
    }
}
