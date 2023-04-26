package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeToCompleteTrips {
    private class Trip{
        int tripTime;
        int timeSpentOnTrip;
        public Trip(int tripTime){
            this.tripTime = tripTime;
            timeSpentOnTrip = tripTime;
        }
        public int getTimeSpentOnTrip(){
            return timeSpentOnTrip;
        }
    }
    public long minimumTime(int[] time, int totalTrips) {
        PriorityQueue<Trip> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Trip::getTimeSpentOnTrip));
        int totalTripsDone = 0;
        int maxTripTime = 0;
        for (int tripTime: time){
            priorityQueue.add(new Trip(tripTime));
        }
        for (int i = 0; i < totalTrips; i++) {
            Trip minTimeTrip = priorityQueue.poll();
            maxTripTime = Math.max(maxTripTime,minTimeTrip.timeSpentOnTrip);
            minTimeTrip.timeSpentOnTrip+=minTimeTrip.tripTime;
            priorityQueue.add(minTimeTrip);
        }
        return maxTripTime;
    }

    public long betterSolution(int[] time, int totalTrips){
        long minTrip = Integer.MAX_VALUE;
        for (int tripTime: time){
            minTrip = Math.min(minTrip,tripTime);
        }
        long maxTime = minTrip*totalTrips;
        long minTime = 1;
        while(minTime<maxTime){
            long midTime = (minTime+maxTime)/2;
            if(isGivenTimeEnough(time,totalTrips,midTime)){
                maxTime = midTime;
            }
            else{
                minTime = midTime+1;
            }
        }
        return minTime;
    }

    private boolean isGivenTimeEnough(int[] time, int totalTrips, long givenTime){
        long totalTripsDone = 0;
        for(int tripTime : time){
            totalTripsDone+=givenTime/tripTime;
            if(totalTripsDone>=totalTrips)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumTimeToCompleteTrips mt = new MinimumTimeToCompleteTrips();
        int time[] = {1,2,3}, totalTrips = 6;
        System.out.println(mt.minimumTime(time,totalTrips));
        System.out.println(mt.betterSolution(time,totalTrips));
    }
}
