package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashSet<Integer> nonRootNodes = new HashSet<>();
        for (List<Integer> edge:edges){
            nonRootNodes.add(edge.get(1));
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!nonRootNodes.contains(i))
                result.add(i);
        }
        return result;
    }
}
