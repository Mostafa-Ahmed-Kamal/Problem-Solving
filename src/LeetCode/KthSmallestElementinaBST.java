package LeetCode;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 */
public class KthSmallestElementinaBST {
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
    int kthSmallest ;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallest = -1;
        kthSmallestRecusrive(root, k , 1);
        return kthSmallest;
    }
    public int kthSmallestRecusrive(TreeNode node, int k, int currentSearch){

        if(node.left!=null){
            currentSearch = kthSmallestRecusrive(node.left, k , currentSearch);
        }
        if(k==currentSearch){
            kthSmallest = node.val;
        }
        if(node.right!=null){
            currentSearch = kthSmallestRecusrive(node.right, k, currentSearch+1);
            return currentSearch;
        }
        return currentSearch+1;
    }

    public static void main(String[] args) {
        KthSmallestElementinaBST kse = new KthSmallestElementinaBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        System.out.println(kse.kthSmallest(root,1));
        System.out.println(kse.kthSmallest(root,2));
        System.out.println(kse.kthSmallest(root,3));
        System.out.println(kse.kthSmallest(root,4));

        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(kse.kthSmallest(root,3));

    }
}
