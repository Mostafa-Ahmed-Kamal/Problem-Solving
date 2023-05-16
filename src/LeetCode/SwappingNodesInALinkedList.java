package LeetCode;

import LeetCode.Utils.ListNode;


public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fastNode = head, slowNode = head;
        for (int i = 1; i < k; i++) {
            if (fastNode==null)return head;
            fastNode = fastNode.next;
        }
        ListNode kFromStartNode = fastNode;
        while(fastNode.next!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        int startValue = kFromStartNode.val;
        kFromStartNode.val = slowNode.val;
        slowNode.val = startValue;
        return head;
    }
}
