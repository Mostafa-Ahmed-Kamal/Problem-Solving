package LeetCode;

import LeetCode.Utils.QuadTree;

public class ConstructQuadTree {
    public QuadTree.Node construct(int[][] grid) {
        return constructRecursive(grid,0, grid.length, 0,grid.length);
    }
    private QuadTree.Node constructRecursive(int[][] grid, int startX, int endX, int startY, int endY){
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if(grid[i][j]!=grid[startX][startY]){
                    QuadTree.Node node = new QuadTree.Node();
                    int midX = startX + (endX-startX)/2;
                    int midY = startY + (endY-startY)/2;
                    node.topLeft = constructRecursive(grid,startX,midX,startY,midY);
                    node.topRight = constructRecursive(grid,startX,midX,midY,endY);
                    node.bottomLeft = constructRecursive(grid,midX,endX,startY,midY);
                    node.bottomRight = constructRecursive(grid,midX,endX,midY,endY);
                    return node;
                }
            }
        }
        return new QuadTree.Node(grid[startX][startY]==1,true);
    }
}
