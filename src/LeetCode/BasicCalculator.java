package LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class BasicCalculator {
    private String prefixToPostfix(String s){
        //(-a+b) = (0-a+b)
        s = s.replace(" ","").replace("(-","(0-");
        // -a+b = 0-a+b
        if(s.charAt(0)=='-')s = '0'+s;
        Stack<Character> operations = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        int iterator = 0;
        while(iterator<s.length()){
            char c = s.charAt(iterator);
            if(c=='('){
                operations.push(c);
            }
            else if(c=='+' || c=='-' || c==')'){
                while(!operations.isEmpty() && operations.peek()!='('){
                    postfix.append(operations.pop()).append(" ");
                }
                if(c!=')')
                    operations.push(c);
                else if(!operations.isEmpty() && operations.peek()=='(')
                    operations.pop();
            }
            else{
                StringBuilder token = new StringBuilder();
                while(iterator<s.length() && Character.isDigit(s.charAt(iterator))){
                    token.append(s.charAt(iterator));
                    iterator++;
                }
                postfix.append(token.toString()).append(" ");
                iterator--;
            }
            iterator++;
        }
        while(!operations.isEmpty()){
            postfix.append(operations.pop());
        }
        return postfix.toString();
    }
    private int operate(String operand, int val1, int val2){
        if(operand.equals("-"))return val1-val2;
        return val1+val2;
    }
    private int evaluatePostfix(String s){
        String operands[] = s.split(" ");
        Stack<Integer> values = new Stack<>();
        for(String operand:operands){
            if(operand.matches("-?(0|[1-9]\\d*)"))values.push(Integer.parseInt(operand));
            else if(values.size()>=2){
                int val2 = values.pop();
                int val1 = values.pop();
                values.push(operate(operand,val1,val2));
            }
            else{
                return -1;
            }
        }
        if(values.size()==1) return values.pop();
        return -1;
    }
    public int calculate(String s) {
        String postfix = prefixToPostfix(s);
        System.out.println(postfix);
        return evaluatePostfix(postfix);
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate("1-(     -2)"));
    }
}
