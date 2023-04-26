package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    private class NodeIndex{
        TreeNode node;
        int index;
        public NodeIndex(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<NodeIndex> queue = new LinkedList<>();
        int maxWidth=0;
        queue.add(new NodeIndex(root,0));
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            int start=0, end=0;
            for (int i = 0; i < queueSize; i++) {
                NodeIndex nodeIndex = queue.poll();
                if (i==0)
                    start = nodeIndex.index;
                if (i==queueSize-1)
                    end = nodeIndex.index;

                if(nodeIndex.node.left!=null)
                    queue.add(new NodeIndex(nodeIndex.node.left,2*nodeIndex.index));
                if (nodeIndex.node.right!=null)
                    queue.add(new NodeIndex(nodeIndex.node.right,2*nodeIndex.index+1));
            }
            maxWidth = Math.max(maxWidth,end-start+1);
        }
        return maxWidth;
    }
}
