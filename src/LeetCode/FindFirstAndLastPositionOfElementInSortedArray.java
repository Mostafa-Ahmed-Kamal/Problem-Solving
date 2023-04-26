package LeetCode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    int[] result;
    public int[] searchRange(int[] nums, int target) {
        result = new int[]{-1,-1};
        binarySearch(nums,target,0,nums.length-1,true);
        binarySearch(nums,target,0,nums.length-1,false);
        return result;
    }
    private void binarySearch(int[] nums, int target, int start, int end, boolean searchForStart){
        if(end<start)return;
        int mid = start + (end-start)/2;
        if(nums[mid]==target){
            if(searchForStart){
                if(mid>0 && nums[mid-1]==target) {
                    binarySearch(nums, target, start,mid-1,true);
                    return;
                }
                result[0] = mid;
            }
            else{
                if(mid<nums.length-1 && nums[mid+1]==target){
                    binarySearch(nums,target,mid+1,end,false);
                    return;
                }
                result[1] = mid;
            }
        }
        else if(nums[mid]>target){
            binarySearch(nums,target,start,mid-1,searchForStart);
        }
        else{
            binarySearch(nums,target,mid+1,end,searchForStart);
        }
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray ffs = new FindFirstAndLastPositionOfElementInSortedArray();
        int nums[] = {5,7,7,8,8,10}, target = 8;
        System.out.println(Arrays.toString(ffs.searchRange(nums,target)));
    }
}
