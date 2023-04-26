package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * given a linked list
 * determine if it has a cycle or not
 * this problem is solved using Floyd's cycle detection algorithm (the rabbit and the turtle)
 * the rabbit moves twice as fast as the turtle
 * if there is no loop then the rabbit would find the end of the line faster than the turtle and the function ends as soon
 * as that happens
 * if a cycle occurs eventually the turtle would be at the same spot as the rabbit in one of the cycles
 * if this happens, it's an indication of a cycle and the algorithm returns false
 */
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode rabbit,turtle;
        rabbit = head;
        turtle = head;
        while(rabbit!=null){
            if(rabbit.next==null)return false;
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if(rabbit == turtle)return true; // detected a cycle
        }
        return false;
    }

}
