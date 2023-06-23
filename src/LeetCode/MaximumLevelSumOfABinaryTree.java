package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxLevelSum=Integer.MIN_VALUE, level=1;
        int iterator = 1;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            int levelSum = 0;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (node==null)continue;
                levelSum+=node.val;
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            if (maxLevelSum<levelSum){
                maxLevelSum = levelSum;
                level = iterator;
            }
            iterator++;
        }
        return level;
    }

    public static void main(String[] args) {
        MaximumLevelSumOfABinaryTree ml = new MaximumLevelSumOfABinaryTree();
        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(-200);
        root.right = new TreeNode(-300);
        root.left.left = new TreeNode(-20);
        root.left.right = new TreeNode(-5);
        root.right.left = new TreeNode(-10);
        System.out.println(ml.maxLevelSum(root));
    }
}
