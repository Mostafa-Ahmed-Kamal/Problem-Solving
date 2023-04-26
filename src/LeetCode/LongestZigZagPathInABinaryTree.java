package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.HashMap;

public class LongestZigZagPathInABinaryTree {
    HashMap<TreeNode,int[]> dp;
    int longestRoute;
    public int longestZigZag(TreeNode root) {
        dp = new HashMap<>();
        longestRoute = 0;
        longestZigZagRecursive(root,0);
        return longestRoute-1;
    }
    // 0 -> left , 1 -> right
    private int longestZigZagRecursive(TreeNode node, int direction){
        if (node==null)return 0;
        if (dp.containsKey(node))return dp.get(node)[direction];
        int[] nodeDirections = new int[2];
        nodeDirections[0] = 1+longestZigZagRecursive(node.right, 1);
        nodeDirections[1] = 1+longestZigZagRecursive(node.left, 0);
        int maxOfNode = Math.max(nodeDirections[0],nodeDirections[1]);
        longestRoute = Math.max(longestRoute,maxOfNode);
        dp.put(node,nodeDirections);
        return nodeDirections[direction];
    }

    public static void main(String[] args) {
        LongestZigZagPathInABinaryTree lz = new LongestZigZagPathInABinaryTree();

    }
}
