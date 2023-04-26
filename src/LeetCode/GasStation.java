package LeetCode;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int gasInTank = gas[i]-cost[i];
            if(gasInTank<0)continue;
            for (int j = 1; j < n; j++) {
                int currentStation = (i+j)%n;
                gasInTank += gas[currentStation] - cost[currentStation];
                if(gasInTank<0) {
                    i+=j-1;
                    break;
                }
            }
            if(gasInTank>=0)return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
//        int[] gas = {0,0,0,0,1,0}, cost = {0,0,0,1,0,0};
        System.out.println(gs.canCompleteCircuit(gas,cost));
    }
}
