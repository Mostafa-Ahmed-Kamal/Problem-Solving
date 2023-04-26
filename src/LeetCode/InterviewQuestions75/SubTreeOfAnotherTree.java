package LeetCode.InterviewQuestions75;

import LeetCode.Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubTreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null)continue;
            if(matchRoots(node,subRoot))return true;
            queue.add(node.left);
            queue.add(node.right);
        }
        return false;
    }
    public boolean matchRoots(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1==null || root2==null)return false;
        if(root1.val==root2.val)return matchRoots(root1.left,root2.left) && matchRoots(root1.right,root2.right);
        return false;
    }

    public static void main(String[] args) {
        SubTreeOfAnotherTree st = new SubTreeOfAnotherTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(st.isSubtree(root,subRoot));
    }
}
