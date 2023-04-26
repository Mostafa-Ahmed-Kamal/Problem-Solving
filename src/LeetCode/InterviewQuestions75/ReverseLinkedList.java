package LeetCode.InterviewQuestions75;

import LeetCode.Utils.ListNode;

public class ReverseLinkedList {
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
}
