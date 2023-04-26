package LeetCode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 */
public class BalancedBinaryTree {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public boolean isBalanced(TreeNode root) {
        return depth(root)!=-1;
    }
    public int depth(TreeNode node){
        if(node==null)return 0;

        int depthLeft = depth(node.left);
        int depthRight = depth(node.right);

        if(Math.abs(depthRight-depthLeft)>1)return -1;
        if(depthLeft==-1 || depthRight==-1)return -1;
        return Math.max(depthLeft,depthRight)+1;
    }
}
