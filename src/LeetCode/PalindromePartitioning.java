package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new LinkedList<>();
        partitionRecursive(s,new LinkedList<>());
        return result;
    }

    private void partitionRecursive(String s, List<String> partition){
        if(s.length()==0){
            result.add(new LinkedList<>(partition));
            return;
        }
        for (int i=1; i<=s.length(); i++){
            String subS = s.substring(0,i);
            if(!isPalindrome(subS))continue;
            partition.add(subS);
            partitionRecursive(s.substring(i), partition);
            partition.remove(partition.size()-1);
        }
    }
    private boolean isPalindrome(String s){
        int left = 0, right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        String s = "aaba";
        System.out.println(pp.partition(s));
    }
}
