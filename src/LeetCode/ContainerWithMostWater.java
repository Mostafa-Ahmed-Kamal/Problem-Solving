package LeetCode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start=0, end=height.length-1;
        int maxArea=0;
        while(start<end){
            int currentArea = (end-start)*Math.min(height[start],height[end]);
            maxArea = Math.max(maxArea,currentArea);
            if(height[start]<height[end])start++;
            else end--;
        }
        return maxArea;
    }
}
