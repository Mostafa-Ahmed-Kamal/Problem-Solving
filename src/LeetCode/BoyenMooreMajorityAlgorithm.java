package LeetCode;
/*
given an array of values (any type) were 1 value is repeated more than half of the size of the array (majority)
return that value
 */
public class BoyenMooreMajorityAlgorithm<T>{
    public T getMajorityCandidate(T[] arr){
        T candidate = null;
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            if(count==0){
                candidate = arr[i];
                count = 1;
            }
            else if(arr[i].equals(candidate)){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        BoyenMooreMajorityAlgorithm<Character> bmma = new BoyenMooreMajorityAlgorithm<>();
        // 'a' is majority it obtains more than half the array size
        Character[] arr = {'a','a','b','c','a','a','a','a','a','a','a','a','c','b','b','c','d','e'};
        System.out.println(bmma.getMajorityCandidate(arr));
    }
}
