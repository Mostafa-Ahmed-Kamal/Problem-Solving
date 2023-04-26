package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Stack<TreeNode> leftOrderStack = new Stack<>();
        Stack<TreeNode> rightOrderStack = new Stack<>();
        leftOrderStack.push(root);
        while(!leftOrderStack.isEmpty() || !rightOrderStack.isEmpty()){
            if(!leftOrderStack.isEmpty()) {
                List<Integer> leftZigzag = new LinkedList<>();
                while (!leftOrderStack.isEmpty()) {
                    TreeNode node = leftOrderStack.pop();
                    if(node==null)continue;
                    leftZigzag.add(node.val);
                    rightOrderStack.push(node.left);
                    rightOrderStack.push(node.right);
                }
                if(leftZigzag.size()>0)
                    result.add(leftZigzag);
            }
            if(!rightOrderStack.isEmpty()) {
                List<Integer> rightZigzag = new LinkedList<>();
                while (!rightOrderStack.isEmpty()) {
                    TreeNode node = rightOrderStack.pop();
                    if(node==null)continue;
                    rightZigzag.add(node.val);
                    leftOrderStack.push(node.right);
                    leftOrderStack.push(node.left);
                }
                if(rightZigzag.size()>0)
                    result.add(rightZigzag);
            }
        }
        return result;
    }
}
