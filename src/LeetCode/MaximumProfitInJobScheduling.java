package LeetCode;

import java.util.*;

public class MaximumProfitInJobScheduling {
    private class mapInfo{
        int busyUntil;
        int jobIndex;
        public mapInfo(int busyUntil, int jobIndex) {
            this.busyUntil = busyUntil;
            this.jobIndex = jobIndex;
        }
    }
    private class Job{
        int start;
        int end;
        int profit;
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    HashMap<mapInfo,Integer> memoaization;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
//        memoaization = new HashMap<>();
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(jobs,Comparator.comparingInt(job->job.end));
        // one solution would be by using jobSchedulingRecursive
        // a better solution is by using a tree map as dp where is brings you the last job where you can
        // schedual on top of and its max revenue
        int maxProfit = 0;
        TreeMap<Integer,Integer> dp = new TreeMap<>();
        dp.put(0,0); // as started endTime = 0 and maxProfit = 0;
        for (Job job:jobs){
            int highestValidEndTime = dp.floorKey(job.start);
            int currentProfit = dp.get(highestValidEndTime) + job.profit;
            maxProfit = Math.max(currentProfit,maxProfit);
            dp.put(job.end,maxProfit);
        }
        return maxProfit;
    }
    private int jobSchedulingRecursive(int jobIndex, Job[] jobs, int busyUntil){
        if(jobIndex>=jobs.length)return 0;
        mapInfo mapInfo = new mapInfo(busyUntil,jobIndex);
        if(memoaization.containsKey(mapInfo)){
            return memoaization.get(mapInfo);
        }
        if(jobs[jobIndex].start<busyUntil){
            return jobSchedulingRecursive(jobIndex+1,jobs,busyUntil);
        }
        Job job = jobs[jobIndex];
        int takingTheJob = job.profit + jobSchedulingRecursive(jobIndex+1,jobs,job.end);
        int notTakingTheJob = jobSchedulingRecursive(jobIndex+1,jobs,busyUntil);
        int max = Math.max(takingTheJob,notTakingTheJob);
        memoaization.put(mapInfo,max);
        return max;
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling j = new MaximumProfitInJobScheduling();
        int[] startTime = {1,1,1}, endTime = {2,3,4}, profit = {100,20,134};
        System.out.println(j.jobScheduling(startTime,endTime,profit));
    }
}
