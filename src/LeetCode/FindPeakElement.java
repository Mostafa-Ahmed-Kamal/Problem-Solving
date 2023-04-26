package LeetCode;

public class FindPeakElement {
    /*
    A peak element is an element that is greater than both of his neighbors
     */
    public int findPeakElement(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    private int binarySearch(int[] nums, int start, int end){
        if(start>=end)return start;
        int mid = start + (end-start)/2;
        if(nums[mid+1]>nums[mid]){
            return binarySearch(nums, mid+1,end);
        }
        return binarySearch(nums,start,mid);
    }

    public static void main(String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = {4,11,5,6,8,9,10,11};
        System.out.println(fpe.findPeakElement(nums));
    }
}
