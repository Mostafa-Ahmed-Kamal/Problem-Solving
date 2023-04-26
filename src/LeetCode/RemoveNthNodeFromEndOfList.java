package LeetCode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 *
 * create a rabbit and turtle node
 * the rabbit is faster than the turtle by n+1 nodes
 * whenever the rabbit reaches the end (null) the turtle is in the position of n-1 from the end
 * now all we need to do is (turtle.next = turtle.next.next)
 */
public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int diff = n+1;
        ListNode turtle = head;
        ListNode rabbit = head;

        for(int i=0; i<diff; i++){
            if(rabbit!=null) rabbit = rabbit.next;
            else if(i==diff-1){
                return head.next;
            }
            else return null;
        }

        while(rabbit!=null){
            rabbit = rabbit.next;
            turtle = turtle.next;
        }
        turtle.next = turtle.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
