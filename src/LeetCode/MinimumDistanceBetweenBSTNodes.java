package LeetCode;

import LeetCode.Utils.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    private int minimumDifference;
    private int previousChild;
    public int minDiffInBST(TreeNode root) {
        minimumDifference = Integer.MAX_VALUE;
        previousChild = Integer.MAX_VALUE;
        compareConsecutive(root);
        return minimumDifference;
    }
    private void compareConsecutive(TreeNode node){
        if(node==null)return;
        compareConsecutive(node.left);
        minimumDifference = Math.min(minimumDifference,Math.abs(previousChild-node.val));
        previousChild = node.val;
        compareConsecutive(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        MinimumDistanceBetweenBSTNodes mbs = new MinimumDistanceBetweenBSTNodes();
        System.out.println(mbs.minDiffInBST(root));
    }
}
