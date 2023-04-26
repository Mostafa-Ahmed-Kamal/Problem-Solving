package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer,Integer> preorderMap;
    HashMap<Integer,Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)return null;
        TreeNode root = new TreeNode(preorder[0]);
        preorderMap = new HashMap<>(); //node value, index in preorder array
        inorderMap = new HashMap<>(); //node value, index in inorder array
        for (int i = 0; i < preorder.length; i++) {
            preorderMap.put(preorder[i],i);
            inorderMap.put(inorder[i],i);
        }
        return buildTreeRecursive(root,0, preorder.length-1,inorder,preorder);
    }
    public TreeNode buildTreeRecursive(TreeNode node, int min, int max, int[] inorder, int[] preorder){
        if(node==null) return null;
        int nodeIndex = inorderMap.get(node.val);
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        int minIndex,maxIndex;
        if(min!=nodeIndex) {
            minIndex = preorder.length;
            for (int i = min; i < nodeIndex; i++) {
                minIndex = Math.min(minIndex,preorderMap.get(inorder[i]));
            }
            leftChild = new TreeNode(preorder[minIndex]);
        }
        if(max!=nodeIndex) {
            maxIndex = preorder.length;
            for (int i = nodeIndex+1; i <= max; i++) {
                maxIndex = Math.min(maxIndex,preorderMap.get(inorder[i]));
            }
            rightChild = new TreeNode(preorder[maxIndex]);
        }
        node.left = buildTreeRecursive(leftChild,min,nodeIndex-1,inorder,preorder);
        node.right = buildTreeRecursive(rightChild,nodeIndex+1,max,inorder,preorder);
        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal c = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int preorder[] = {3,9,4,8,2,1,5}, inorder[] = {9,8,3,1,5,2,4};
        TreeNode root = c.buildTree(preorder,inorder);
        root.printTree(root);
    }
}
