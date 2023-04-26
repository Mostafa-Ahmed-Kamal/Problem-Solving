package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            Node previousNode = queue.poll();
            for (int i = 1; i < queueSize; i++) {
                previousNode.next = queue.poll();
                addChildren(previousNode,queue);
                previousNode = previousNode.next;
            }
            addChildren(previousNode,queue);
        }
        return root;
    }
    private void addChildren(Node node, Queue<Node> queue){
        if(node==null)return;
        Node leftNode = node.left;
        Node rightNode = node.right;
        if(leftNode!=null)queue.add(leftNode);
        if(rightNode!=null)queue.add(rightNode);
    }
}
