package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaximumPathSum {
    HashMap<TreeNode,Integer> memoaization;
    public int maxPathSum(TreeNode root) {
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        memoaization = new HashMap<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                queue.add(node.left);
                queue.add(node.right);
                int leftMax = maxPathSumDFS(node.left);
                int rightMax = maxPathSumDFS(node.right);
                int pathMax = leftMax+rightMax+node.val;
                max = Math.max(pathMax,max);
            }
        }
        return max;
    }
    public int maxPathSumDFS(TreeNode node){
        if(node==null)return 0;
        if(memoaization.containsKey(node))return memoaization.get(node);
        int leftMax = maxPathSumDFS(node.left);
        int rightMax = maxPathSumDFS(node.right);
        int max = Math.max(0,node.val+Math.max(leftMax, rightMax));
        memoaization.put(node,max);
        return max;
    }
/******************************************************************************************/
/******************************************************************************************/
    int maxSum = Integer.MIN_VALUE;
    public int betterSolution(TreeNode root){
        DFS(root);
        return maxSum;
    }
    public int DFS(TreeNode node){
        if(node==null)return 0;
        int left = DFS(node.left);
        int right = DFS(node.right);
        maxSum = Math.max(maxSum,left+right+node.val);
        return Math.max(left,right)+node.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(btmps.maxPathSum(root));
        System.out.println(btmps.betterSolution(root));
    }
}
