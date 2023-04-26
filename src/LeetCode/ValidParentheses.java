package LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        Stack<Character> openParentheses = new Stack<>();
        for (char c : s.toCharArray()){
            if(map.containsKey(c)){
                openParentheses.add(c);
            }
            else if(openParentheses.size()==0 || map.get(openParentheses.pop())!=c){
                return false;
            }
        }
        return openParentheses.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "{[]}[]";
        System.out.println(vp.isValid(s));
    }
}
