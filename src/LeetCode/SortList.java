package LeetCode;

import java.util.List;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * Example 2:
 *
 *
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 *
 * solved via a quick sort alike technique
 * recursively take the head node and create from its value a listNodeRight, ListNodeLeft
 * were ListNodeLeft -> head -> ListNodeRight
 * recursively sort each listNode until size==0 or 1
 * NOTE: THIS SOLUTION IS NOT FAST
 *
 * a faster solution would be using top down merge sort
 */
public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void printList(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.val+"  ");
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        return sortListRecursive(head)[0];
    }
    // [head,tail]
    public ListNode[] sortListRecursive(ListNode head){
        if(head==null || head.next == null)return new ListNode[]{head,head};
        int pivot = head.val;
        ListNode lsl =null; //ListNodeLeft
        ListNode lsr =null; //ListNodeRight
        ListNode lslhead =null; //ListNodeLeft
        ListNode lsrhead =null; //ListNodeRight
        ListNode curr = head.next;
        while(curr!=null){
            if(curr.val<pivot){
                if(lslhead==null) {
                    lslhead = curr;
                    lsl = lslhead;
                }
                else {
                    lsl.next = curr;
                    lsl = lsl.next;
                }
            }
            else{
                if(lsrhead==null) {
                    lsrhead = curr;
                    lsr = lsrhead;
                }
                else {
                    lsr.next = curr;
                    lsr = lsr.next;
                }
            }
            curr = curr.next;
        }
        // cut it into 2 lists
        if(lsr!=null) lsr.next=null;
        if(lsl!=null) lsl.next=null;
        // sort each list separately
        ListNode[] lslArray = sortListRecursive(lslhead);
        ListNode[] lsrArray = sortListRecursive(lsrhead);
        lslhead = lslArray[0];
        lsl = lslArray[1];

        lsrhead = lsrArray[0];
        lsr = lsrArray[1];

        // lsl -> head -> lsr
        head.next = lsrhead;
        if(lslhead!=null) {
            lsl.next = head;
        }

        head.next = lsrhead;
        ListNode h=head,t=head;
        if(lslhead!=null) h=lslhead;
        if(lsr!=null) t=lsr;

        return new ListNode[]{h,t};
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    /** SECOND APPROACH USING TOP DOWN MERGE SORT  **/
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode right = getMid(head);
        ListNode left = sortList2(head);
        right = sortList2(right);
        return merge(left, right);
    }

    ListNode merge(ListNode left, ListNode right) {
        ListNode newHead = null;
        ListNode newPointer = null;
        while(left!=null && right!=null){
            if(left.val<right.val){
                if(newHead==null){
                    newHead = left;
                    newPointer = newHead;
                }
                else{
                    newPointer.next = left;
                    newPointer = newPointer.next;
                }
                left = left.next;
            }
            else{
                if(newHead==null){
                    newHead = right;
                    newPointer = newHead;
                }
                else{
                    newPointer.next = right;
                    newPointer = newPointer.next;
                }
                right = right.next;
            }
        }
        newPointer.next = left==null? right:left;
        return newHead;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);


        SortList sl = new SortList();
        sl.printList(sl.sortList(head)); // quick sort
        sl.printList(sl.sortList2(head));// merge sort
        // Note: merge sort is faster in than quick sort in this problem
    }
}
