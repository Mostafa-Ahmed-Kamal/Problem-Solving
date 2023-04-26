package LeetCode.HardProblems;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftPointer =0;
        int minKIndex=-1,maxKIndex=-1;
        long subArraysCount=0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            if(nums[rightPointer]<minK || nums[rightPointer]>maxK){
                leftPointer = rightPointer+1;
                minKIndex=-1;maxKIndex=-1;
                continue;
            }
            minKIndex = nums[rightPointer]==minK?rightPointer:minKIndex;
            maxKIndex = nums[rightPointer]==maxK?rightPointer:maxKIndex;
            if(minKIndex!=-1 && maxKIndex!=-1){
                subArraysCount += Math.min(minKIndex,maxKIndex)-leftPointer+1;
            }
        }
        return subArraysCount;
    }

    public static void main(String[] args) {
        CountSubarraysWithFixedBounds cfb = new CountSubarraysWithFixedBounds();
        int nums[] = {1,3,5,2,7,5}, minK = 1, maxK = 5;
        System.out.println(cfb.countSubarrays(nums,minK,maxK));
    }
}
