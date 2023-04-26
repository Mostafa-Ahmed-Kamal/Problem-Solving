package LeetCode;

public class NumberOfProvinces {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provincesCount =0;
        visited = new boolean[n];
        for (int i=0; i<n; i++){
            if(!visited[i]){
                provincesCount++;
                dfs(i,isConnected,n);
            }
        }
        return provincesCount;
    }
    private void dfs(int nodeIndex, int[][] isConnected, int n){
        if(visited[nodeIndex])return;
        visited[nodeIndex] = true;
        for (int i=0; i<n; i++){
            if(isConnected[nodeIndex][i]==1)dfs(i,isConnected,n);
        }
    }
}
