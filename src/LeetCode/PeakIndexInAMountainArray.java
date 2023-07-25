package LeetCode;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        return findMaxBinarySearch(arr,0,arr.length-1);
    }
    private int findMaxBinarySearch(int[] arr, int start, int end){
        if(start>=end)return start;
        int mid = start + (end-start)/2;
        if (arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1])return mid;
        if (arr[mid]<arr[mid+1])return findMaxBinarySearch(arr,mid+1,end);
        return findMaxBinarySearch(arr,start,mid-1);
    }

    public static void main(String[] args) {
        PeakIndexInAMountainArray pm = new PeakIndexInAMountainArray();
        int[] arr = {3,4,5,1};
        System.out.println(pm.peakIndexInMountainArray(arr));
    }
}
