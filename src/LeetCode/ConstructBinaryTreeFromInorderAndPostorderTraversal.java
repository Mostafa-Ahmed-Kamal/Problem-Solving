package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int[] inorder, postorder;
    int postOrderRootIndex;
    HashMap<Integer,Integer> inOrderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postOrderRootIndex = postorder.length-1;
        inOrderMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i],i);
        }
        return buildTreeRecursive(0,inorder.length-1);
    }
    private TreeNode buildTreeRecursive(int start, int end){
        if(end<start) return null;
        int rootValue = postorder[postOrderRootIndex];
        TreeNode root = new TreeNode(rootValue);
        int inOrderRootIndex = inOrderMap.get(rootValue);
        postOrderRootIndex--;
        root.right = buildTreeRecursive(inOrderRootIndex+1,end);
        root.left = buildTreeRecursive(start,inOrderRootIndex-1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal cs = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = {9,3,15,20,7}, postorder = {9,15,7,20,3};
        cs.buildTree(inorder,postorder);
    }
}
