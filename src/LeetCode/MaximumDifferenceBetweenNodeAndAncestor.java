package LeetCode;

import LeetCode.Utils.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
    private class minMax{
        int min;
        int max;
        public minMax(int min, int max){
            this.max = max;
            this.min = min;
        }
    }
    int maxResult;
    public int maxAncestorDiff(TreeNode root) {
        maxResult = 0;
        maxDiffRecursive(root, new minMax(root.val,root.val));
        return maxResult;
    }
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    private minMax maxDiffRecursive(TreeNode node, minMax minMax){
        if(node == null)return minMax;
        minMax currentMinMax = new minMax(Math.min(node.val, minMax.min), Math.max(node.val, minMax.max));
        minMax left = maxDiffRecursive(node.left, currentMinMax);
        minMax right = maxDiffRecursive(node.right, currentMinMax);

        minMax result = new minMax(Math.min(left.min, right.min), Math.max(left.max, right.max));
        int currentMaxDifference = Math.max(node.val- result.min, result.max - node.val);
        maxResult = Math.max(maxResult, currentMaxDifference);
        return result;
    }

}
