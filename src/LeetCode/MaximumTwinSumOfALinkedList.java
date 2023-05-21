package LeetCode;

import LeetCode.Utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        List<Integer> nodesVal = new ArrayList<>();
        while(head!=null){
            nodesVal.add(head.val);
            head = head.next;
        }
        int maxSum = 0;
        int listSize = nodesVal.size();
        for (int i = 0; i < listSize/2; i++) {
            maxSum = Math.max(maxSum,nodesVal.get(i)+nodesVal.get(listSize-1-i));
        }
        return maxSum;
    }
}
