package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class ErectTheFence {

    private int orientation(int[] onHull, int[] next, int[] potentialPoint){
        int x1=onHull[0],x2=next[0],x3=potentialPoint[0];
        int y1=onHull[1],y2=next[1],y3=potentialPoint[1];
        int orientation = (x2-x1)*(y3-y2)-(x3-x2)*(y2-y1);
        return Integer.compare(orientation, 0); // 1 means clockwise, 0 means linear and 1 means clockwise
    }
    private boolean inBetween(int[] onHull, int[] potentialPoint, int[] next){
        boolean a = potentialPoint[0] >= onHull[0] && potentialPoint[0] <= next[0] || potentialPoint[0] <= onHull[0] && potentialPoint[0] >= next[0];
        boolean b = potentialPoint[1] >= onHull[1] && potentialPoint[1] <= next[1] || potentialPoint[1] <= onHull[1] && potentialPoint[1] >= next[1];
        return a && b;
    }
    public int[][] outerTrees(int[][] trees) {
        if(trees.length<4) return trees;
        int leftMostIndex = 0;
        HashSet<int[]> hull = new HashSet<>();
        for(int i=0; i<trees.length; i++){
            if(trees[i][0]<trees[leftMostIndex][0]){
                leftMostIndex = i;
            }
        }
        int onHull = leftMostIndex;
        do {
            int next = (onHull + 1) % trees.length;
            for (int i = 0; i < trees.length; i++) {
                if(hull.contains(trees[i]))continue;
                if (orientation(trees[onHull], trees[i], trees[next]) == -1) {
                    next = i;
                }
            }
            for (int i = 0; i < trees.length; i++) {
                if(hull.contains(trees[i]))continue;
                if (i != onHull && i != next && orientation(trees[onHull], trees[i], trees[next]) == 0 && inBetween(trees[onHull], trees[i], trees[next])) {
                    hull.add(trees[i]);
                }
            }
            hull.add(trees[next]);
            onHull = next;
        }
        while (onHull != leftMostIndex);
        return hull.toArray(new int[hull.size()][]);
    }

    public static void main(String[] args) {
        ErectTheFence ef = new ErectTheFence();
        int trees[][] = {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
        System.out.println(Arrays.deepToString(ef.outerTrees(trees)));
    }
}
