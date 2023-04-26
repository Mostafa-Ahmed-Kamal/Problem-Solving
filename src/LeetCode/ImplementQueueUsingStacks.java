package LeetCode;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    private static class MyQueue{
        Stack<Integer> stack;
        Stack<Integer> queue;
        public MyQueue() {
            stack = new Stack<>();
            queue = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
        }

        private void fillQueue(){
            if(!queue.isEmpty())return;
            while(!stack.isEmpty()){
                queue.push(stack.pop());
            }
        }
        public int pop() {
            if(queue.isEmpty()){
                fillQueue();
            }
            return queue.pop();
        }

        public int peek() {
            if(queue.isEmpty()){
                fillQueue();
            }
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty() && stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
