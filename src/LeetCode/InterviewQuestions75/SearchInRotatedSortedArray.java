package LeetCode.InterviewQuestions75;
/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 */
public class SearchInRotatedSortedArray {
        public int search(int[] nums, int target) {
            System.out.println("we are searching for : "+ target);
            return searchRecursive(0,nums.length-1, nums, target);
        }
        public int searchRecursive(int start, int end, int[] nums, int target){
            if(end-start < 2){
                if(nums[start]==target)return start;
                else if(nums[end]==target)return end;
                return -1;
            }
            int middle = start + (end-start)/2;
            System.out.println("middle index is : "+middle + " with a value of: " + nums[middle] );
            if(nums[middle]==target)return middle;
            else{
                if(nums[middle]>nums[middle-1] && nums[middle]<nums[middle+1]){
                    //right is bigger and left is smaller
                    if( ((nums[middle+1]>nums[end]) &&  (target >=nums[middle+1] || target <= nums[end]))
                            ||
                            (target >=nums[middle+1] && target <= nums[end]))
                        return searchRecursive(middle+1,end, nums, target);
                    else if(((nums[start]>nums[middle+1]) &&  (target >=nums[start] || target <= nums[middle+1]))
                            ||
                            (target >=nums[start] && target <= nums[middle+1]))
                        return searchRecursive(start,middle-1, nums, target);
                    else return -1;
                }
                else
                // first or last element
                {
                    if(nums[end]>=target)
                        return searchRecursive(middle+1,end, nums, target);
                    else if(nums[start]<=target)
                        return searchRecursive(start,middle-1, nums, target);
                    return -1;
                }
            }
        }
        public static void main(String[] args) {
            SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
            int[] nums = {4,5,6,7,0,1,2};
            int target = 0;
            System.out.println(test.search(nums, target));
        }
    }
