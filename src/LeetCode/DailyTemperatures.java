package LeetCode;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();
        for(int i=0; i<n; i++){
            int ithTemperature = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] < ithTemperature){
                int pastDay = stack.pop();
                result[pastDay] = i - pastDay;
            }
            stack.push(i);
        }
        return result;
    }
}
