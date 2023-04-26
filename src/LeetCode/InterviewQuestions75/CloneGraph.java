package LeetCode.InterviewQuestions75;

import LeetCode.Utils.Node;

import java.util.HashMap;
import java.util.HashSet;

public class CloneGraph {
    HashSet<Node> visited = new HashSet<>();
    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return cloneGraphRecursive(node, new Node(node.val));
    }

    public Node cloneGraphRecursive(Node node, Node newNode) {
        visited.add(node);
        map.put(node,newNode);
        for(Node neighbor: node.neighbors){
            Node newNeighbor = map.getOrDefault(neighbor,new Node(neighbor.val));
            newNode.neighbors.add(newNeighbor);
            if(!visited.contains(neighbor)) {
                cloneGraphRecursive(neighbor, newNeighbor);
            }
        }
        return newNode;
    }
    HashSet<Node> v = new HashSet<>();
    public void printList(Node node){
        if(v.contains(node)) return;
        v.add(node);
        for (Node neighbor : node.neighbors){
            System.out.print(" "  + neighbor.val);
        }
        System.out.println();
        for (Node neighbor : node.neighbors){
            printList(neighbor);
        }

    }

    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(three);
        four.neighbors.add(one);
        cg.printList(one);
        System.out.println("--------------------");
        cg.printList(cg.cloneGraph(one));
    }

}
