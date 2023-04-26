package LeetCode.InterviewQuestions75;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        /*
        if left (&& right not necessarily needed) greater than me => i am the smallest number
        if my right is less than me => my right is the smallest element
        if left is smaller and right is greater {
            if last element from the right is less than me => smallest value is on the left
            else => smallest value is on the right
        }
         */
        return findMinRecursive(nums, 0, nums.length-1);
    }
    public int findMinRecursive(int[] nums, int start, int end){
        if(end-start<2) return Math.min(nums[start], nums[end]);
        int mid = start + (end-start)/2;
        int value = nums[mid];
        if(nums[mid-1]>value) return value;
        if(nums[mid+1]<value) return nums[mid+1];
        if(nums[end]<value) return findMinRecursive(nums,mid+1, end);
        return findMinRecursive(nums, start, mid-1);
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fmrs = new FindMinimumInRotatedSortedArray();
        int nums[] = {8,9,1,2,3,4,5,6,7};
        System.out.println(fmrs.findMin(nums));

    }
}
