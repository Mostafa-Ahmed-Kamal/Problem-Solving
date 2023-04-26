package LeetCode;

import java.util.LinkedList;

public class MinimumFuelCostToReportToTheCapital {
    LinkedList<Integer>[] graph;
    long totalFuel;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length+1;
        totalFuel = 0;
        constructGraph(roads,n);
        countCars(seats,0,-1);
        return totalFuel;
    }
    private long countCars(int seats, int nodeId, int parentId){
        long totalCarsNeeded = 1;
        for (int children:graph[nodeId]){
            if(children==parentId)continue;
            long rootTotalCars = countCars(seats,children,nodeId);
            totalFuel += Math.ceil((double)rootTotalCars/seats);
            totalCarsNeeded += rootTotalCars;
        }
        return totalCarsNeeded;
    }
    private void constructGraph(int[][] roads, int n){
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList();
        }
        for (int[] road:roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
    }

    public static void main(String[] args) {
        MinimumFuelCostToReportToTheCapital mfc = new MinimumFuelCostToReportToTheCapital();
        int roads[][] = {{0,1},{1,2},{1,3},{4,2},{5,3},{6,3},{6,7},{8,6},{9,0},
                        {5,10},{11,9},{12,5},{5,13},{8,14},{11,15},{8,16},{17,0},{18,7}};
        int seats = 13;
        System.out.println(mfc.minimumFuelCost(roads,seats));
    }
}
