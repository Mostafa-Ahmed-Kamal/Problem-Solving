package LeetCode.HardProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    private class Project{
        int profit,capital;
        public Project(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
        public int getCapital(){
            return capital;
        }
        public int getProfit(){
            return profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i],capital[i]);
        }
        Arrays.sort(projects,Comparator.comparingInt(Project::getCapital));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int projectsIndex=0;
        int resultingCapital = w;
        for (int i = 0; i < k; i++) {
            while(projectsIndex<n && projects[projectsIndex].getCapital()<=resultingCapital){
                priorityQueue.add(projects[projectsIndex].getProfit());
                projectsIndex++;
            }
            if(priorityQueue.isEmpty())return resultingCapital;
            int bestProject = priorityQueue.poll();
            if(bestProject<0)return resultingCapital;
            resultingCapital += bestProject;
        }
        return resultingCapital;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int k = 2, w = 0, profits[] = {1,2,3}, capital[] = {0,1,1};
        System.out.println(ipo.findMaximizedCapital(k,w,profits,capital));
    }
}
