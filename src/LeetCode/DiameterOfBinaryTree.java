package LeetCode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 */
public class DiameterOfBinaryTree {

    private static class TreeNode {
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
    private static int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0 ;
        LongestPath(root);
        return diameter;
    }
    public int LongestPath(TreeNode node){
        if(node==null)return 0;

        int lengthLeft = LongestPath(node.left);
        int lengthRight = LongestPath(node.right);
        diameter = Math.max(diameter,lengthLeft+lengthRight);
        return Math.max(lengthLeft,lengthRight)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
        System.out.println(dbt.diameterOfBinaryTree(root));
    }
}
