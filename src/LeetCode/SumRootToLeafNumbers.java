package LeetCode;

import LeetCode.Utils.TreeNode;

public class SumRootToLeafNumbers {
    StringBuilder currentRootToLeafValue;
    int rootToLeafSum;
    public int sumNumbers(TreeNode root) {
        currentRootToLeafValue = new StringBuilder();
        rootToLeafSum = 0;
        rootToLeafSum(root);
        return rootToLeafSum;
    }
    private void rootToLeafSum(TreeNode node){
        if(node == null){
            return;
        }
        currentRootToLeafValue.append(node.val);
        if(node.left==null && node.right==null) { //leaf node
            rootToLeafSum += Integer.parseInt(currentRootToLeafValue.toString());
        }
        rootToLeafSum(node.right);
        rootToLeafSum(node.left);
        currentRootToLeafValue.deleteCharAt(currentRootToLeafValue.length()-1);
    }
    public static void main(String[] args) {
        SumRootToLeafNumbers srt = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(srt.sumNumbers(root));
    }
}
