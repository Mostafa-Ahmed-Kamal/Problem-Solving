package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeafSimilarTrees {
    Queue<Integer> queue;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        queue = new LinkedList<>();
        fillQueue(root1);
        boolean result = deFillQueue(root2);
        return result && queue.isEmpty();
    }
    boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    public void fillQueue(TreeNode root1){
        if(root1==null)return;
        if(isLeaf(root1)) {
            queue.add(root1.val);
            return;
        }
        fillQueue(root1.left);
        fillQueue(root1.right);
    }

    public boolean deFillQueue(TreeNode root1){
        if(root1==null)return true;
        if(isLeaf(root1)) {
            return !queue.isEmpty() && queue.poll() == root1.val;
        }
        return deFillQueue(root1.left) && deFillQueue(root1.right);
    }
}
