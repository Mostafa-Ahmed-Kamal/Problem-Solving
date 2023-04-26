package LeetCode;

import java.util.HashMap;
/// VIP
/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 */
public class PathSumIII {

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
    int target, count;
    HashMap<Integer,Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        count = 0;
        map = new HashMap();
        map.put(0,1);
        recursivePath(root,0);
        return count;
    }
    public void recursivePath(TreeNode node, int curr){
        if(node==null)return;
        curr+=node.val;
        count += map.getOrDefault(curr-target,0);
        map.put(curr,map.getOrDefault(curr,0)+1);
        recursivePath(node.left,curr);
        recursivePath(node.right,curr);
        map.put(curr,map.getOrDefault(curr,0)-1);
    }
}
