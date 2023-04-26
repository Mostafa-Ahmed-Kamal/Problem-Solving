package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidRecursive(root, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY*-1);
    }
    public boolean isValidRecursive(TreeNode node, double max, double min){
        if(node==null)return true;
        if(node.val<=min || node.val>=max)return false;
        return isValidRecursive(node.left, node.val, min) && isValidRecursive(node.right, max, node.val);
    }

    public static void main(String[] args) {
        ValidBST vb = new ValidBST();
        TreeNode root = new TreeNode(0);
        System.out.println(vb.isValidBST(root));
    }
}
