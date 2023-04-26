package LeetCode;

import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        Stack<Integer> s = new Stack<>();
        ListNode turtle = head;
        ListNode rabbit = head;

        while(rabbit.next!=null && rabbit.next.next!=null){
            s.add(turtle.val);
            turtle = turtle.next;
            rabbit = rabbit.next.next;
        }
        if(rabbit.next!=null)s.add(turtle.val); // the list is even

        turtle = turtle.next;

        while(turtle!=null){
            if(turtle.val == s.peek())s.pop();
            else return false;
            turtle = turtle.next;
        }
        return s.isEmpty();
    }
}
