package LeetCode.InterviewQuestions75;

import LeetCode.Utils.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mimicHead = new ListNode();
        ListNode sortedHead = mimicHead;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                sortedHead.next = list1;
                list1 = list1.next;
            }
            else{
                sortedHead.next = list2;
                list2 = list2.next;
            }
            sortedHead = sortedHead.next;
        }
        sortedHead.next = list1==null? list2:list1;
        return mimicHead.next;
    }
    public void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists ms = new MergeTwoSortedLists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);

        ms.printList(ms.mergeTwoLists(list1,list2));
    }
}
