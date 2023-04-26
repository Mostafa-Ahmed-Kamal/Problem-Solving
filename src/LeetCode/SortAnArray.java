package LeetCode;

import java.util.Arrays;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public int[] quickSort(int[] nums, int start, int end){
        if(end-start<2)return nums;
        int pivot = nums[end-1];
        int firstLargestElement = start-1;
        for (int i = start; i < end-1; i++) {
            if(nums[i]<pivot){
                firstLargestElement++;
                swapElements(nums,firstLargestElement,i);
            }
        }
        firstLargestElement++;
        swapElements(nums,firstLargestElement,end-1);
        quickSort(nums,start,firstLargestElement);
        quickSort(nums,firstLargestElement+1,end);
        return nums;
    }
    private void mergeSort(int[] nums, int start, int end){
        if(start>=end)return;
        int mid = (end+start)/2;
        mergeSort(nums,start,mid);
        mergeSort(nums,mid+1,end);
        combine(nums,start,mid,end);
    }
    private void combine(int[] nums, int start, int mid, int end){
        int[] result = new int[end-start+1];
        int resultIterator=0;
        int left=start,right=mid+1;
        while(left<=mid && right<=end){
            if(nums[left]<=nums[right]){
                result[resultIterator++]=nums[left++];
            }
            else{
                result[resultIterator++]=nums[right++];
            }
        }
        while(left<=mid){
            result[resultIterator++]=nums[left++];
        }
        while(right<=end){
            result[resultIterator++]=nums[right++];
        }
        for (int i = 0; i < resultIterator; i++) {
            nums[i+start] = result[i];
        }
    }
    private boolean isSorted(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1])return false;
        }
        return true;
    }
    private void swapElements(int[] nums, int e1, int e2){
        int temp = nums[e1];
        nums[e1] = nums[e2];
        nums[e2] = temp;
    }

    public static void main(String[] args) {
        SortAnArray sa = new SortAnArray();
        int[] nums = {5,1,1,2,0,0};
        System.out.println(Arrays.toString(sa.sortArray(nums)));
    }
}
