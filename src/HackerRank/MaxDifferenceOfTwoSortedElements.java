package HackerRank;

public class MaxDifferenceOfTwoSortedElements {
    /*
    #rules:
    given an unsorted array, return the maximum difference between two values were the small one's index is less
    the big one.

    #solution: pass on the array from right to left getting the maximum value from that, this value
    represents the maximum possible value from the following index till the end,
    compare that max value with the current index you are in and calculate the difference,
    store the maximum distance you get.

    time complexity --> O(n)
     */
    public int maxDistance(int[] array){
        int maxValue = Integer.MIN_VALUE;
        int maxDifference = 0;
        for(int i = array.length-1; i >= 0 ; i--){
            if(array[i]>maxValue){
                maxValue = array[i];
            }
            if( (maxValue - array[i]) > maxDifference ){
                maxDifference = (maxValue - array[i]);
            }
        }
        return maxDifference;
    }

    public static void main(String[] args) {
        MaxDifferenceOfTwoSortedElements m = new MaxDifferenceOfTwoSortedElements();
        int array[] = {1,2,4,4,5,6,7,8,9,10,11,12};
        System.out.println(m.maxDistance(array));
    }
}
