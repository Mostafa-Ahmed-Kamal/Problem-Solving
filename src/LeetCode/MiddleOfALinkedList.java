package LeetCode;

import LeetCode.Utils.ListNode;

public class MiddleOfALinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode rabbit = head, turtle = head;
        while(rabbit!=null && rabbit.next!=null){
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }
}
