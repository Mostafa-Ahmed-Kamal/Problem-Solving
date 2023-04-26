package LeetCode;

import LeetCode.Utils.TreeNode;

public class CountCompleteTreeNodes {
    int missingCount;
    public int countNodes(TreeNode root) {
        missingCount = 0;
        int maxLength = maxLength(root);
        incompleteNodesCount(root,0,maxLength);
        return (int) (Math.pow(2,maxLength)-1-missingCount);
    }

    public int maxLength(TreeNode node){
        if(node==null)return 0;
        return 1+maxLength(node.left);
    }

    public boolean incompleteNodesCount(TreeNode node, int currentDepth, int maxLength){
        if(currentDepth==maxLength)return true;
        if(node==null) {
            missingCount++;
            return false;
        }
        boolean isOverYet = incompleteNodesCount(node.right, currentDepth+1,maxLength);
        if(!isOverYet) isOverYet = incompleteNodesCount(node.left,currentDepth+1,maxLength);
        return isOverYet;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        CountCompleteTreeNodes ct = new CountCompleteTreeNodes();
        System.out.println(ct.countNodes(root));
    }
}
