package LeetCode.InterviewQuestions75;

import LeetCode.Utils.ListNode;
import LeetCode.Utils.Utils;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode rabbit = head, turtle = head;
        int n = 0;
        while(rabbit!=null && rabbit.next!=null){
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            n++;
        }
        turtle = reverseList(turtle);
        ListNode mimicHead = new ListNode();
        ListNode current = mimicHead;
        for (int i = 0; i < n; i++) {
            current.next = head;
            head = head.next;
            current.next.next = turtle;
            turtle = turtle.next;
            current = current.next.next;
        }
        head = mimicHead.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        ListNode prev = null;
        while(head!=null){
            current = head;
            head = head.next;
            current.next = prev;
            prev = current;
        }
        return current;
    }

    public static void main(String[] args) {
        ReorderList rl = new ReorderList();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
        rl.reorderList(head);
        Utils.printList(head);
    }
}
