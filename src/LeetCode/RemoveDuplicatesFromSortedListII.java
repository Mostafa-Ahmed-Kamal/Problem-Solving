package LeetCode;

import LeetCode.Utils.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode mainNode = dummyHead;
        ListNode duplicateStartNode = head;
        ListNode duplicateEndNode = head;
        while(duplicateEndNode!=null){
            while(duplicateEndNode!=null && duplicateStartNode.val==duplicateEndNode.val){
                duplicateEndNode = duplicateEndNode.next;
            }
            if(duplicateStartNode.next==duplicateEndNode){
                mainNode.next = duplicateStartNode;
                mainNode = mainNode.next;
            }
            duplicateStartNode = duplicateEndNode;
        }
        mainNode.next=null;
        return dummyHead.next;
    }
}
