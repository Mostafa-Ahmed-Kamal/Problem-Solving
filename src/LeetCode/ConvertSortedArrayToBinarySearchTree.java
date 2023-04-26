package LeetCode;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 */
public class ConvertSortedArrayToBinarySearchTree {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRecusrive(nums , 0 , nums.length-1);
    }
    public TreeNode sortedArrayToBSTRecusrive(int[] nums , int start, int end){
        if(end-start<2){
            TreeNode node = new TreeNode(nums[start]);
            node.right = start==end? null: new TreeNode(nums[end]);
            return node;
        }
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBSTRecusrive(nums, start, Math.max(start,mid-1));
        node.right = sortedArrayToBSTRecusrive(nums, Math.min(end,mid+1),end);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree csbt = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = {-10,-3,0,5,9};
        csbt.sortedArrayToBST(nums);
    }
}
