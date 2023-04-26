package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {
    int minDifference;
    int lastAddedNodeValue;
    public int getMinimumDifference(TreeNode root) {
        minDifference = Integer.MAX_VALUE;
        lastAddedNodeValue = Integer.MAX_VALUE;
        inOrderTraversal(root);
        return minDifference;
    }
    private void inOrderTraversal(TreeNode node){
        if(node==null)return;
        inOrderTraversal(node.left);
        minDifference = Math.min(minDifference,Math.abs(node.val-lastAddedNodeValue));
        lastAddedNodeValue = node.val;
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST mbst = new MinimumAbsoluteDifferenceInBST();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        System.out.println(mbst.getMinimumDifference(root));
    }
}
