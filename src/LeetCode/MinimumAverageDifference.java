package LeetCode;

public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int minAverage = Integer.MAX_VALUE, minID = 0;
        double leftSum=0, leftCount = 0;
        double rightSum=0, rightCount = n;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i=0; i<n; i++) {
            int num = nums[i];
            leftSum+=num;
            leftCount++;
            rightSum-=num;
            rightCount--;
            int leftAverage = (int)(leftSum/leftCount);
            int rightAverage = rightCount==0? 0:(int)(rightSum/rightCount);
            int currentMin = Math.abs(leftAverage - rightAverage);
            System.out.println(leftAverage + " " + rightAverage + " := " + currentMin);
            if(currentMin<minAverage){
                minAverage = currentMin;
                minID = i;
            }
        }
        return minID;
    }

    public static void main(String[] args) {
        MinimumAverageDifference ma = new MinimumAverageDifference();
        int[] nums = {2,5,3,9,5,3};
        System.out.println(ma.minimumAverageDifference(nums));
    }
}
