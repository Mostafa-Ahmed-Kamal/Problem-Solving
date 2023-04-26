package LeetCode;
/*
#### PROBLEM STATEMENT:
given an array of size N+1 that contains values from min to max (max-min = N)
all values are unique except one value is duplicated twice
#### OBJECTIVE : find that value
 */
public class FindDuplicatedElement {
    // USING XOR
    public int findDuplicatedElement1(int[] arr , int min , int max){
        int XORRange = min;
        int XORArr = arr[0];
        for(int i=min+1 ; i<=max ; i++){
            XORRange = XORRange^i; // XOR
        }
        for (int i = 1; i < arr.length; i++) {
            XORArr = XORArr ^ arr[i]; // XOR
        }
        return XORArr^XORRange;
    }
    // MY THOUGHTS ABOUT THE PROBLEM USING SUM
    public int findDuplicatedElement2(int[] arr , int min , int max){
        int RangeSum = 0;
        int ArraySum = 0;
        for (int i = min; i <= max ; i++) {
            RangeSum+=i;
        }
        for (int i = 0; i < arr.length; i++) {
            ArraySum+=arr[i];
        }
        return ArraySum-RangeSum;
    }
    public int[] getMinMax(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min , arr[i]);
            max = Math.max(max , arr[i]);
        }
        return new int[] {min,max};
    }
    public static void main(String[] args){
        // the array should contain all unique values within the range min->max with only 1 element duplicated
        // don't expect it to run correctly if the array doesn't follow the specifications
        FindDuplicatedElement fde = new FindDuplicatedElement();
        int[] arr = {5,4,6,7,3,2,9,10,1,8,5}; // 5 is duplicated
        int[] MinMAx = fde.getMinMax(arr);
        System.out.println(fde.findDuplicatedElement1(arr,MinMAx[0],MinMAx[1]));
        System.out.println(fde.findDuplicatedElement2(arr,MinMAx[0],MinMAx[1]));
    }
}
