package LeetCode.InterviewQuestions75;

import LeetCode.Utils.ListNode;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsRecursive(lists, 0, lists.length-1);
    }

    public ListNode mergeKListsRecursive(ListNode[] lists, int start, int end){
        if(end-start==1) return  mergeTwoLists(lists[start],lists[end]);
        else if(end==start) return lists[start];

        int mid = start + (end-start)/2;
        ListNode mergeLeft = mergeKListsRecursive(lists, start, mid);
        ListNode mergeRight = mergeKListsRecursive(lists, mid+1, end);
        return mergeTwoLists(mergeLeft,mergeRight);
    }

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

    public static void main(String[] args) {
        ListNode lists[] = new ListNode[2];

    }
}
