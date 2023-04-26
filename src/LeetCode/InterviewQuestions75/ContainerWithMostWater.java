package LeetCode.InterviewQuestions75;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0, currentArea=0;
        int left=0, right=height.length-1;
        while(left<right){
            currentArea = Math.min(height[left],height[right])*(right-left);
            maxArea = Math.max(maxArea,currentArea);
            if (height[left]>height[right])right--;
            else left++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cw = new ContainerWithMostWater();
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(cw.maxArea(height));
    }
}
