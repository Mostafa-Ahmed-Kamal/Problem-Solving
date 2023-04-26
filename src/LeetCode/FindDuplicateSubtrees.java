package LeetCode;

import LeetCode.Utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindDuplicateSubtrees {
    HashMap<String,Integer> subTrees;
    List<TreeNode> repeatedSubTrees;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTrees = new HashMap<>();
        repeatedSubTrees = new LinkedList<>();
        inorderTraversal(root);
        return repeatedSubTrees;
    }
    private String inorderTraversal(TreeNode node){
        StringBuilder representation = new StringBuilder();
        if(node==null) {
            representation.append("N+");
        }
        else if(isLeaf(node)){
            representation.append(node.val+"+");
        }
        else {
            representation.append(inorderTraversal(node.left)+"+");
            representation.append(node.val+"+");
            representation.append(inorderTraversal(node.right)+"+");
        }
        String subTree = representation.toString();
        subTrees.put(subTree,subTrees.getOrDefault(subTree,0)+1);
        if(subTrees.get(subTree)==2 && node!=null) {
            repeatedSubTrees.add(node);
        }
        return subTree;
    }
    private boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }

    public static void main(String[] args) {

    }
}
