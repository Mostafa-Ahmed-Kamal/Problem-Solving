package LeetCode;

import LeetCode.Utils.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null || high<low) return 0;
        int nodeValue = root.val;
        int sum = 0;
        if(nodeValue>=low && nodeValue<=high) sum +=nodeValue;
        sum += rangeSumBST(root.left, low, Math.min(high, nodeValue));
        sum += rangeSumBST(root.right, Math.max(low, nodeValue), high);
        return sum;
    }

}
