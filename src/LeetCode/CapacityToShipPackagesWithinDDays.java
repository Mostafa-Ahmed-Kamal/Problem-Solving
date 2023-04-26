package LeetCode;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int lowerBound = 0;
        int upperBound = 0;
        for (int weight:weights){
            upperBound+=weight;
            lowerBound=Math.max(lowerBound,weight);
        }
        int result = upperBound;
        while(lowerBound<=upperBound){
            int mid = lowerBound + (upperBound-lowerBound)/2;
            boolean works = doesItWork(weights,days,mid);
            if(works){
                result = mid;
                upperBound = mid-1;
            }
            else{
                lowerBound = mid+1;
            }
        }
        return result;
    }
    private boolean doesItWork(int[] weights, int days, int maxWeight){
        int daysWeight=0, day=0;
        for(int weight:weights){
            if(daysWeight+weight>maxWeight){
                daysWeight=0;
                day++;
            }
            if(day>=days)return false;
            daysWeight+=weight;
        }
        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays cs = new CapacityToShipPackagesWithinDDays();
        int weights[] = {1,2,3,4,5,6,7,8,9,10}, days = 5;
        System.out.println(cs.shipWithinDays(weights,days));
    }
}
