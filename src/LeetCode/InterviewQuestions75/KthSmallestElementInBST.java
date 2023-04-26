package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

public class KthSmallestElementInBST {
    private int kthSmallestElement;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestElement = -1;
        kthSmallestRecursive(root,k,1);
        return kthSmallestElement;
    }
    private int kthSmallestRecursive(TreeNode node, int k, int currentK){
        if(node==null) return currentK;
        if(node.left!=null){
            currentK = kthSmallestRecursive(node.left,k,currentK);
        }
        if(currentK==k){
            kthSmallestElement = node.val;
        }
        if(node.right!=null){
            currentK = kthSmallestRecursive(node.right,k,currentK+1)-1;
        }
        return currentK+1;
    }
    public static void main(String[] args) {
        KthSmallestElementInBST kbst = new KthSmallestElementInBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kbst.kthSmallest(root,3));
    }
}
