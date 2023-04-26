package LeetCode;

public class LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf && quadTree2.isLeaf){
            return quadTree1.val?quadTree1:quadTree2;
        }
        if(quadTree1.isLeaf){
            return quadTree1.val?quadTree1:quadTree2;
        }
        if(quadTree2.isLeaf){
            return quadTree2.val?quadTree2:quadTree1;
        }
        Node node = new Node();
        node.topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
        node.topRight = intersect(quadTree1.topRight,quadTree2.topRight);
        node.bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
        node.bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
        return joinChildren(node);
    }
    private Node joinChildren(Node node){
        boolean[] isLeaf = {node.topLeft.isLeaf, node.topRight.isLeaf, node.bottomLeft.isLeaf, node.bottomRight.isLeaf};
        boolean[] val = {node.topLeft.val, node.topRight.val, node.bottomLeft.val, node.bottomRight.val};
        for (int i = 0; i < isLeaf.length; i++) {
            if(!isLeaf[i] || val[i]!=val[0])return node;
        }
        Node newNode = new Node();
        newNode.isLeaf = true;
        newNode.val = val[0];
        return newNode;
    }
}
