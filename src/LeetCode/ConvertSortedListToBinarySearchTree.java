package LeetCode;

import LeetCode.Utils.ListNode;
import LeetCode.Utils.TreeNode;

import java.util.ArrayList;

public class ConvertSortedListToBinarySearchTree {
    ArrayList<ListNode> nodes;
    public TreeNode sortedListToBST(ListNode head) {
        nodes = new ArrayList<>();
        while (head!=null){
            nodes.add(head);
            head=head.next;
        }
        return sortedListToBSTRecursive(0,nodes.size()-1);
    }
    private TreeNode sortedListToBSTRecursive(int start, int end){
        if(start>end)return null;
        int mid = (start+end)/2;
        TreeNode localRoot = new TreeNode(nodes.get(mid).val);
        localRoot.left = sortedListToBSTRecursive(start,mid-1);
        localRoot.right = sortedListToBSTRecursive(mid+1,end);
        return localRoot;
    }
}
