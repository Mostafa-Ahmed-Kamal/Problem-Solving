package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}
