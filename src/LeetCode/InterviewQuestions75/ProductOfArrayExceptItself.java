package LeetCode.InterviewQuestions75;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfArrayExceptItself {
    public int[] productExceptSelf(int[] nums) {
        int FullProduct = 1, zeroCounter = 0, zeroIndex=-1;
        for(int i=0; i<nums.length; i++){
            if (nums[i]==0){
                zeroCounter++;
                zeroIndex=i;
            }
            else {
                FullProduct *= nums[i];
            }
        }
        int[] result = new int[nums.length];
        if (zeroCounter>0) {
            result[zeroIndex] = zeroCounter>1? 0:FullProduct;
        }
        else {
            for (int i = 0; i < result.length; i++) {
                result[i] = nums[i] == 0 ? FullProduct : FullProduct / nums[i];
            }
        }
        return result;
    }
    public int[] anotherSolution(int[] nums){
        int result[] = new int[nums.length];
        int postfix=1, prefix=1;
        for(int i=0; i< nums.length; i++){
            result[i]= prefix;
            prefix *= nums[i];
        }
        for(int i=nums.length-1; i>=0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptItself p = new ProductOfArrayExceptItself();
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(p.productExceptSelf(nums)));
        System.out.println(Arrays.toString(p.anotherSolution(nums)));
    }
}
