package LeetCode;

public class MinimumCostForTickets {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length];
        dp[dp.length-1] = Math.min(costs[0],Math.min(costs[1],costs[2]));
        for (int i = days.length-2; i >=0 ; i--) {
            int buyDayTicket = dp[i+1]+costs[0];
            int buyWeekTicket = binarySearch(days,days[i]+7,i,days.length)+costs[1];
            int buyMonthTicket = binarySearch(days,days[i]+30,i,days.length)+costs[2];
            dp[i] = Math.min(buyDayTicket,Math.min(buyWeekTicket,buyMonthTicket));
        }
        return dp[0];
    }
    private int binarySearch(int[] days, int day, int start, int end){
        if (end<=start)return start<days.length?dp[start]:0;
        int mid = (start+end)/2;
        if (days[mid]==day)return dp[mid];
        return days[mid]<day? binarySearch(days,day,mid+1,end):binarySearch(days,day,start,mid);
    }

    public static void main(String[] args) {
        MinimumCostForTickets mct = new MinimumCostForTickets();
        int[] days = {1,4,6,7,8,20,38,42,61,160,200,306}, costs = {2,7,15};
        System.out.println(mct.mincostTickets(days,costs));
    }
}
