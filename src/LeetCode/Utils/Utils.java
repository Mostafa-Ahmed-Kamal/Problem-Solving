package LeetCode.Utils;

public class Utils {
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
