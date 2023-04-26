package LeetCode;

import LeetCode.Utils.ListNode;

import java.util.Random;

public class LinkedListRandomNode {
    int listSize;
    ListNode head;
    Random random = new Random();
    public LinkedListRandomNode(ListNode head) {
        listSize=0;
        this.head = head;
        while(head!=null){
            listSize++;
            head = head.next;
        }
    }
    public int getRandom() {
        return getNode(random.nextInt(listSize));
    }
    public int getNode(int index){
        ListNode iteratorNode = head;
        for (int i = 0; i < index; i++) {
            iteratorNode = iteratorNode.next;
        }
        return iteratorNode.val;
    }
}
