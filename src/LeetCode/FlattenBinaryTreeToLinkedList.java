package LeetCode;

import LeetCode.Utils.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenAndReturnLeaf(root);
    }
    private TreeNode flattenAndReturnLeaf(TreeNode node){
        if (node==null)return null;
        if (isLeaf(node))return node;
        TreeNode leftLeaf = flattenAndReturnLeaf(node.left);
        TreeNode rightLeaf = flattenAndReturnLeaf(node.right);
        if (leftLeaf!=null) {
            leftLeaf.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightLeaf==null?leftLeaf:rightLeaf;
    }
    private boolean isLeaf(TreeNode node){
        return node!=null && node.left==null && node.right==null;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fb = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        fb.flatten(root);
        root.printTree(root);
    }
}
