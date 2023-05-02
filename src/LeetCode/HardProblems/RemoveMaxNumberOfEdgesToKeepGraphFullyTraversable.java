package LeetCode.HardProblems;

import LeetCode.Utils.UnionFind;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind AliceGraph = new UnionFind(n);
        UnionFind BobGraph = new UnionFind(n);
        int edgesRequired = 0;
        for (int[] edge:edges){
            if (edge[0]==3){
                edgesRequired += (AliceGraph.merge(edge[1]-1, edge[2]-1) | BobGraph.merge(edge[1]-1, edge[2]-1));
            }
        }
        for (int[] edge:edges){
            if (edge[0]==1){
                edgesRequired += AliceGraph.merge(edge[1]-1, edge[2]-1);
            }
            else if (edge[0]==2){
                edgesRequired += BobGraph.merge(edge[1]-1,edge[2]-1);
            }
        }
        return BobGraph.isConnected() && AliceGraph.isConnected()? edges.length-edgesRequired : -1 ;
    }
    public static void main(String[] args) {
        RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable rm = new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();
        int n = 4;
        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
        System.out.println(rm.maxNumEdgesToRemove(n,edges));
    }
}
