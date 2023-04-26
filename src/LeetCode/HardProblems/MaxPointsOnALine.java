package LeetCode.HardProblems;

import java.util.*;

public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        int max = 1;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            HashMap<Double,Integer> slopCount = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if(i==j)continue;
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                double slop = deltaX==0?Double.MAX_VALUE : ((double) deltaY/deltaX);
                int count = slopCount.getOrDefault(slop,1)+1;
                max = Math.max(max, count);
                slopCount.put(slop,count);
            }
        }
        return max;
    }
    public class LineEquation{
        // y = slope*x + constant
        Double slope;
        Double constant;
        public LineEquation(double slope, double constant){
            this.slope = slope;
            this.constant = constant;
        }
        public boolean equals(Object o) {
            if (o instanceof LineEquation l) {
                return Objects.equals(l.slope, slope) && Objects.equals(l.constant, constant);
            }
            return false;
        }
        public int hashCode() {
            return slope.hashCode() * 31 + constant.hashCode();
        }
    }
    // uses the concept of line as an equation were y = mx + c;
    public int betterSolution(int[][] points){
        int max = 1;
        int n = points.length;
        HashMap<LineEquation, HashSet<int[]>> pointsOnLine = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int deltaX = points[i][0] - points[j][0];
                int deltaY = points[i][1] - points[j][1];
                Double slope = deltaX==0?Double.MAX_VALUE : ((double) deltaY/deltaX);
                Double constant = slope==Double.MAX_VALUE? points[i][0] : points[i][1] - points[i][0]*slope;
                LineEquation lineEquation = new LineEquation(slope,constant);
                if(!pointsOnLine.containsKey(lineEquation)){
                    pointsOnLine.put(lineEquation, new HashSet<>());
                }
                pointsOnLine.get(lineEquation).add(points[i]);
                pointsOnLine.get(lineEquation).add(points[j]);
            }
        }
        for (Map.Entry<LineEquation, HashSet<int[]>> entry: pointsOnLine.entrySet()){
            max = Math.max(max, entry.getValue().size());
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPointsOnALine mp = new MaxPointsOnALine();
        int[][] points = {{1,4},{1,1},{2,1},{2,2},{3,3}};
        System.out.println(mp.maxPoints(points));
        System.out.println(mp.betterSolution(points));
    }
}
