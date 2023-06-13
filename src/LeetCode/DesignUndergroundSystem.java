package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DesignUndergroundSystem {
    class CheckInInfo{
        final int time;
        final String stationName;
        public CheckInInfo(int time, String stationName){
            this.time = time;
            this.stationName = stationName;
        }
    }
    class UndergroundSystem {
        HashMap<Integer,CheckInInfo> pendingTravels;
        HashMap<String,HashMap<String, List<Integer>>> travelsRecords;
        public UndergroundSystem() {
            pendingTravels = new HashMap<>();
            travelsRecords = new HashMap<>();
        }
        public void checkIn(int id, String stationName, int t) {
            pendingTravels.put(id,new CheckInInfo(t,stationName));
        }

        public void checkOut(int id, String stationName, int t) {
            if(!pendingTravels.containsKey(id))return;
            CheckInInfo travelInfo = pendingTravels.get(id);
            pendingTravels.remove(id);
            travelsRecords.putIfAbsent(travelInfo.stationName,new HashMap<>());
            travelsRecords.get(travelInfo.stationName).putIfAbsent(stationName,new LinkedList<>());
            travelsRecords.get(travelInfo.stationName).get(stationName).add(t-travelInfo.time);
        }

        public double getAverageTime(String startStation, String endStation) {
            if (!travelsRecords.containsKey(startStation) || !travelsRecords.get(startStation).containsKey(endStation))return 0;
            List<Integer> travels = travelsRecords.get(startStation).get(endStation);
            double result = 0;
            int travelsCount = travels.size();
            for (int travel:travels){
                result += (double)travel/travelsCount;
            }
            return result;
        }
    }
}
