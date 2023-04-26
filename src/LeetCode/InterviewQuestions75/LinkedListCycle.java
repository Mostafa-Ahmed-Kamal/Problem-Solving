package LeetCode.InterviewQuestions75;

import LeetCode.Utils.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode rabbit = head, turtle = head;
        while(rabbit != null && rabbit.next != null && rabbit.next.next != null){
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if(rabbit == turtle) return true;
        }
        return false;
    }
}
