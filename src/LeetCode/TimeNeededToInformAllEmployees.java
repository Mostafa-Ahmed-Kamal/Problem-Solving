package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] informedAtTimeX = new int[n];
        HashMap<Integer, List<Integer>> nodes = new HashMap<>();
        for (int i=0; i<manager.length; i++){
            int managerID = manager[i];
            if (managerID==-1)continue;
            nodes.putIfAbsent(managerID,new LinkedList<>());
            nodes.get(managerID).add(i);
        }
        int maxTime = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(headID);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            int treeLevelTime = 0;
            for (int i = 0; i < queueSize; i++) {
                int managerID = queue.poll();
                maxTime = Math.max(maxTime,informedAtTimeX[managerID]);
                if (!nodes.containsKey(managerID))continue;
                for (int subordinates:nodes.get(managerID)){
                    queue.add(subordinates);
                    informedAtTimeX[subordinates] = informedAtTimeX[managerID] + informTime[managerID];
                }
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {
        TimeNeededToInformAllEmployees tn = new TimeNeededToInformAllEmployees();
        int n = 1, headID = 0, manager[] = {-1}, informTime[] = {0};
        System.out.println(tn.numOfMinutes(n,headID,manager,informTime));
    }
}
