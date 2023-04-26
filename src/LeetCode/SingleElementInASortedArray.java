package LeetCode;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int start=0, end = nums.length-1;
        while(start<end){

            int mid = start+(end-start)/2;
            int chunkSize = mid-start;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])return nums[mid];
            if(chunkSize%2==0) {
                if(nums[mid]==nums[mid-1]) end = mid;
                else start = mid;
            }
            else {
                if(nums[mid]==nums[mid-1]) start = mid+1;
                else end = mid-1;
            }
        }
        return nums[start];
    }
    public int anotherApproach(int[] nums){
        int start=0, end=nums.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]==nums[mid+1])mid--;
            int leftChunkSize = mid-start+1;
            if(leftChunkSize%2==0) start = mid+1;
            else end = mid;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray sm = new SingleElementInASortedArray();
        int[] nums = {1,1,2,2,3,3,4,4,8,8,9};
        System.out.println(sm.singleNonDuplicate(nums));
        System.out.println(sm.anotherApproach(nums));
    }
}
