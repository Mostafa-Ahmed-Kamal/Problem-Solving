package LeetCode.HardProblems;

public class MaximumNumberOfAchievableTransferRequests {
    int[] buildingsNeeds;
    public int maximumRequests(int n, int[][] requests) {
        buildingsNeeds = new int[n];
        return maximumRequestsDP(requests,0,0);
    }
    private int maximumRequestsDP(int[][] requests, int requestID, int totalDoneRequests){
        if (requestID>=requests.length){
            for (int buildingNeed:buildingsNeeds){
                if (buildingNeed!=0)return 0;
            }
            return totalDoneRequests;
        }
        int ignoreRequest = maximumRequestsDP(requests,requestID+1,totalDoneRequests);
        buildingsNeeds[requests[requestID][0]]--;
        buildingsNeeds[requests[requestID][1]]++;
        int approveRequest = maximumRequestsDP(requests,requestID+1,totalDoneRequests+1);
        buildingsNeeds[requests[requestID][0]]++;
        buildingsNeeds[requests[requestID][1]]--;
        return Math.max(ignoreRequest,approveRequest);
    }

    public static void main(String[] args) {
        MaximumNumberOfAchievableTransferRequests ma = new MaximumNumberOfAchievableTransferRequests();
        int n = 5, requests[][] = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        System.out.println(ma.maximumRequests(n,requests));
    }
}
