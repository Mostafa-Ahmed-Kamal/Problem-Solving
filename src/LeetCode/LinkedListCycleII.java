package LeetCode;

import LeetCode.Utils.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        while(head!=null){
            if(visitedNodes.contains(head))return head;
            visitedNodes.add(head);
            head = head.next;
        }
        return null;
    }
    public ListNode betterApproach(ListNode head){
        ListNode rabbit = head;
        ListNode turtle = head;
        while(rabbit!=null && rabbit.next!=null){
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if(rabbit==turtle){
                turtle = head;
                while(rabbit!=turtle){
                    rabbit=rabbit.next;
                    turtle=turtle.next;
                }
                return rabbit;
            }
        }
        return null;
    }
}
