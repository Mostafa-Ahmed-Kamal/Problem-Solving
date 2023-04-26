package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.LinkedList;

public class SumOfDistancesInTree {
    LinkedList<Integer>[] graph;
    int[] result;
    int[] count;
    int N;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        graph = new LinkedList[n];
        result = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge:edges){
            int nodeI = edge[0], nodeJ = edge[1];
            graph[nodeI].add(nodeJ);
            graph[nodeJ].add(nodeI);
        }
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }
        dfsParents(0,-1);
        dfsChildren(0,-1);
        return result;
    }
    /// calculateParents:-> each parent's result is equal to the sum of its children's (subTree_Count + subTree Sum)
    private void dfsParents(int nodeID, int parent){
        for (int child:graph[nodeID]){
            if(child!=parent){
                dfsParents(child, nodeID);
                count[nodeID] += count[child];
                result[nodeID] += count[child] + result[child];
            }
        }
    }
    /// calculateChildren:-> each child's result is equal to the sum of:
    ///                                     *- his subTree_sum
    ///                                     *- his parents_subTree_sum which is equal 2 parent_subTree_count + parent_subTree_sum
    ///                                     *- parent_subTree_count = N - child_subCount
    ///                                     *- parent_subTree_sum   = parent_total_count - child_cubCount - child_subSum

    private void dfsChildren(int nodeID, int parent){
        for (int child:graph[nodeID]){
            if(child!=parent){
                result[child] = result[nodeID] + N - 2*count[child];
                dfsChildren(child,nodeID);
            }
        }
    }

    public static void main(String[] args) {
        SumOfDistancesInTree sdt = new SumOfDistancesInTree();
        int n = 6, edges[][] = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        System.out.println(Arrays.toString(sdt.sumOfDistancesInTree(n,edges)));
    }
}
