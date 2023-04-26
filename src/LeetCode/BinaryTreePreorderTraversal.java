package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new LinkedList<>();
        preorderTraversalRecursive(root);
        return result;
    }
    public void preorderTraversalRecursive(TreeNode node){
        if(node == null) return;
        result.add(node.val);
        preorderTraversalRecursive(node.left);
        preorderTraversalRecursive(node.right);
    }

}
