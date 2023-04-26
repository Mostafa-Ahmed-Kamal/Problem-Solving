package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root==null || isTheSame(root.left,root.right);
    }
    private boolean isTheSame(TreeNode node1, TreeNode node2){
        if((node1==null && node2==null))return true;
        if((node1==null || node2==null) || node1.val!=node2.val)return false;
        return (isTheSame(node1.left,node2.right) && isTheSame(node1.right,node2.left));
    }
    private boolean iterativeApproach(TreeNode root){
        if(root==null)return true;
        Queue<TreeNode> leftMirror = new LinkedList<>();
        Queue<TreeNode> rightMirror = new LinkedList<>();
        leftMirror.add(root.left);
        rightMirror.add(root.right);
        while(!leftMirror.isEmpty() && !rightMirror.isEmpty()){
            TreeNode leftNode = leftMirror.poll();
            TreeNode rightNode = rightMirror.poll();
            if((leftNode==null && rightNode==null))continue;
            if((leftNode==null || rightNode==null) || leftNode.val!=rightNode.val)return false;
            leftMirror.add(leftNode.left);
            leftMirror.add(leftNode.right);
            rightMirror.add(rightNode.right);
            rightMirror.add(rightNode.left);
        }
        return leftMirror.isEmpty() && rightMirror.isEmpty();
    }
}
