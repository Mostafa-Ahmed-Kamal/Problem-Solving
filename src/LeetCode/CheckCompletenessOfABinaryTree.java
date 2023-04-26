package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null){
                while (!queue.isEmpty()){
                    if(queue.poll()!=null)return false;
                }
                return true;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        return true;
    }
}
