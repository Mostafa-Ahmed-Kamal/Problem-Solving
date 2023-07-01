package LeetCode.HardProblems;

public class LastDayWhereYouCanStillCross {
    private final int[][] coordinates = {{-1,0},{1,0},{0,1},{0,-1}};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left =0, right=cells.length;
        while(left<right){
            int mid = right - (right-left)/2;
            if (canCross(row,col,cells,mid)){
                left = mid;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    private boolean canCross(int row, int col, int[][] cells, int day){
        int[][] graph = new int[row+1][col+1];
        for (int i = 0; i < day; i++) {
            graph[cells[i][0]][cells[i][1]]=1;
        }
        for (int j = 1; j < graph[0].length; j++) {
            if (dfs(graph,1,j)) {
                return true;
            }
        }
        return false;
    }
    private boolean dfs(int[][] graph, int row, int col){
        if (row<1 || col<1 || row>=graph.length || col>=graph[0].length || graph[row][col]!=0) return false;
        if (row == graph.length-1)return true;
        graph[row][col]=1;
        for (int[] coordinate:coordinates){
            if (dfs(graph,row + coordinate[0],col + coordinate[1])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LastDayWhereYouCanStillCross ld = new LastDayWhereYouCanStillCross();
        int row = 5, col = 2, cells[][] = {{5,1},{1,2},{3,1},{2,2},{3,2},{1,1},{5,2},{2,1},{4,2},{4,1}};
        System.out.println(ld.latestDayToCross(row,col,cells));
    }
}
