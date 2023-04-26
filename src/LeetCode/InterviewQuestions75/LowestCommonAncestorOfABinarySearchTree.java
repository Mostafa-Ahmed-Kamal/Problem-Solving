package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {
    int max,min;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(q.val>p.val){
            max = q.val;
            min = p.val;
        }
        else{
            max = p.val;
            min = q.val;
        }
        return lcaRecursive(root);
    }
    private TreeNode lcaRecursive(TreeNode node){
        if (node == null) return null;
        if (node.val >= min && node.val <= max) return node;
        if (node.val < min) {
            return lcaRecursive(node.right);
        }
        return lcaRecursive(node.left);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree l = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(l.lowestCommonAncestor(root,root,root.left).val);
    }
}
