package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if(node!=null){
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(!level.isEmpty())result.add(level);
        }
        return result;
    }
}
