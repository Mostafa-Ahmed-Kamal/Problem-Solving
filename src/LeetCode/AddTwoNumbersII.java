package LeetCode;

import LeetCode.Utils.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> firstNumber = new Stack<>();
        Stack<Integer> secondNumber = new Stack<>();
        Stack<ListNode> result = new Stack<>();
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        while(currentL1!=null){
            firstNumber.add(currentL1.val);
            currentL1 = currentL1.next;
        }
        while(currentL2!=null){
            secondNumber.add(currentL2.val);
            currentL2 = currentL2.next;
        }
        int carry = 0;
        while(!firstNumber.isEmpty() || !secondNumber.isEmpty()){
            int digit1 = firstNumber.isEmpty()?0:firstNumber.pop();
            int digit2 = secondNumber.isEmpty()?0:secondNumber.pop();
            int sum = (digit1+digit2+carry)%10;
            carry = (digit1+digit2+carry)/10;
            result.add(new ListNode(sum));
        }
        if (carry!=0)result.add(new ListNode(carry));
        ListNode resultRoot = result.pop();
        ListNode currentNode = resultRoot;
        while (!result.isEmpty()){
            currentNode.next = result.pop();
            currentNode = currentNode.next;
        }
        return resultRoot;
    }
}
