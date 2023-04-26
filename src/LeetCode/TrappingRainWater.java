package LeetCode;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int leftMax = height[0], leftMaxId=0;
        int rightMax = height[n-1], rightMaxId=n-1;
        while(leftMaxId < rightMaxId){
            if(leftMax < rightMax){
                leftMaxId++;
                leftMax = Math.max(leftMax, height[leftMaxId]);
                int trappedWater = leftMax - height[leftMaxId];
                result += Math.max(trappedWater, 0);
            }
            else{
                rightMaxId--;
                rightMax = Math.max(rightMax, height[rightMaxId]);
                int trappedWater = rightMax - height[rightMaxId];
                result += Math.max(trappedWater, 0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        int[] height = {4,2,0,3,2,5};
        System.out.println(trw.trap(height));
    }
}
