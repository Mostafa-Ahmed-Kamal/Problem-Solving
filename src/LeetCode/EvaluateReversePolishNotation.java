package LeetCode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    private int applyOperation(String operand, int op1, int op2){
        return switch (operand) {
            case "+" -> op1 + op2;
            case "*" -> op1 * op2;
            case "-" -> op1 - op2;
            case "/" -> op1 / op2;
            default -> 0;
        };
    }
    public int evalRPN(String[] tokens) throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (String token:tokens){
            if(token.matches("-?\\d+")){
                int value = Integer.parseInt(token);
                stack.push(value);
            }
            else if(stack.size()>=2){
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = applyOperation(token, op1, op2);
                stack.push(result);
            }
            else{
                throw new Exception("Invalid set of operations");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws Exception {
        EvaluateReversePolishNotation ern = new EvaluateReversePolishNotation();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(ern.evalRPN(tokens));
    }
}
