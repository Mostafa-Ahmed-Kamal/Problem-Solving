package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null)result.append("null,");
            else {
                result.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return result.substring(0);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split(",");
        if(nodes.length==0 || nodes[0].equals("null"))return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentNode = root;
        for (int i = 1; i < nodes.length; i++) {
            if(i%2==1)currentNode = queue.poll();
            if(nodes[i].equals("null"))continue;
            int value = Integer.parseInt(nodes[i]);
            if(i%2==1){//odd index is a left node
                currentNode.left = new TreeNode(value);
                queue.add(currentNode.left);
            }
            else{   //even index is a right node
                currentNode.right = new TreeNode(value);
                queue.add(currentNode.right);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree sd = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right= new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right= new TreeNode(7);

        String tree = sd.serialize(root);
        System.out.println(tree);
        TreeNode newRoot = sd.deserialize(tree);
        newRoot.printTree(newRoot);
    }
}
