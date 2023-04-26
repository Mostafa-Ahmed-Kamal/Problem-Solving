package LeetCode.InterviewQuestions75;

import LeetCode.Utils.ListNode;
import LeetCode.Utils.Utils;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode rabbit = head;
        for (int i = 0; i < n+1; i++) {
            if(rabbit!=null) rabbit = rabbit.next;
            else return (i<n)? head:head.next;
        }
        ListNode turtle = head;
        while(rabbit!=null){
            rabbit = rabbit.next;
            turtle = turtle.next;
        }
        turtle.next = turtle.next!=null? turtle.next.next:null;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList rl = new RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(1);
        Utils.printList(rl.removeNthFromEnd(head, 1));
    }

}
