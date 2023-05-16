package LeetCode;

import LeetCode.Utils.ListNode;

import java.util.LinkedList;
import java.util.List;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        List<ListNode> nodes = new LinkedList<>();
        ListNode currentNode = head;
        while(currentNode!=null) {
            if (currentNode.next == null){
                nodes.add(currentNode);
                break;
            }
            else{
                nodes.add(currentNode.next);
                nodes.add(currentNode);
                currentNode = currentNode.next.next;
            }
        }
        if(nodes.size()==0)return head;
        head = nodes.get(0);
        currentNode = head;
        for (int i = 1; i < nodes.size(); i++) {
            currentNode.next = nodes.get(i);
            currentNode = currentNode.next;
        }
        currentNode.next = null;
        return head;
    }
}
