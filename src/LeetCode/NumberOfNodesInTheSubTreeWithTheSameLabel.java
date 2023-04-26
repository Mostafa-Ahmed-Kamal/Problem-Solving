package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    HashSet<Integer>[] graph;
    int[] childrenWithSameLabelCount;
    int[] parentWithSameLabel;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        graph = new HashSet[n];
        childrenWithSameLabelCount = new int[n];
        parentWithSameLabel = new int[26];
        Arrays.fill(parentWithSameLabel,-1);
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
            childrenWithSameLabelCount[i] = 1;
        }
        for (int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        countSubTreeRecursive(labels,0,-1);
        return childrenWithSameLabelCount;
    }

    private void countSubTreeRecursive(String labels, int node, int parent){
        int characterIndex = labels.charAt(node)-'a';
        int labelParent = parentWithSameLabel[characterIndex];
        parentWithSameLabel[characterIndex] = node;
        for (int children: graph[node]){
            if(children==parent)continue;
            countSubTreeRecursive(labels, children, node);
        }
        if(labelParent!=-1) {
            childrenWithSameLabelCount[labelParent] += childrenWithSameLabelCount[node];
        }
        parentWithSameLabel[characterIndex] = labelParent;
    }

    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithTheSameLabel ns = new NumberOfNodesInTheSubTreeWithTheSameLabel();
        int n = 7, edges[][] = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        String labels = "abaedcd";
        System.out.println(Arrays.toString(ns.countSubTrees(n,edges,labels)));
    }
}
