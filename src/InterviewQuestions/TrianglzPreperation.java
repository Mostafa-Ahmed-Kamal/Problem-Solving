package InterviewQuestions;

import java.util.*;

public class TrianglzPreperation {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> inverseValues = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            int inverseValue = target - num;
            if (inverseValues.containsKey(num))return new int[] {i,inverseValues.get(num)};
            inverseValues.put(inverseValue,i);
        }
        return null;
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num:nums){
            if (seen.contains(num))return true;
            seen.add(num);
        }
        return false;
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;
        int[] result = new int[n];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix*=nums[i];
        }
        for (int i = n-1; i >=0 ; i--) {
            result[i] *= suffix;
            suffix*=nums[i];
        }
        return result;
    }

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }
        int count;
        int maxCount = 0;
        for (int num:set){
            if (set.contains(num-1))continue;
            count = 1;
            int currentNumber = num+1;
            while (set.contains(currentNumber)){
                currentNumber++;
                count++;
            }
            maxCount = Math.max(maxCount,count);
        }
        return maxCount;
    }

    public boolean isAnagram(String s, String t) {
        int[] characterFrequencies = new int[26];
        for (char c:s.toCharArray()){
            characterFrequencies[c-'a']++;
        }
        for (char c:t.toCharArray()){
            characterFrequencies[c-'a']--;
        }
        for (int freq:characterFrequencies){
            if (freq!=0)return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> groups = new HashMap<>();
        for (String str:strs){
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);
            groups.putIfAbsent(sortedString,new LinkedList<>());
            groups.get(sortedString).add(str);
        }
        List<List<String>> result = new LinkedList<>(groups.values());
        return result;
    }

    private class keyValue{
        int key;
        int value;
        public keyValue(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey(){
            return key;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencies = new HashMap<>();
        for (int num:nums){
            frequencies.put(num,frequencies.getOrDefault(num,0)+1);
        }
        PriorityQueue<keyValue> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(keyValue::getKey).reversed());
        for (Map.Entry<Integer,Integer> entry:frequencies.entrySet()){
            priorityQueue.add(new keyValue(entry.getValue(),entry.getKey()));
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().key;
        }
        return result;
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase(Locale.ROOT);
        s = s.replaceAll("[^a-z0-9]","");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)!=s.charAt(n-i-1))return false;
        }
        return true;
    }

    List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i=0 ; i<nums.length; i++){
            if (i!=0 && nums[i]==nums[i-1])continue;
            twoSumSorted(nums, i);
        }
        return result;
    }
    private void twoSumSorted(int[] nums, int chosenElementsIndex){
        int left = chosenElementsIndex+1, right = nums.length-1;
        while(left<right){
            int sum = nums[chosenElementsIndex] + nums[left] + nums[right];
            if (sum<0){
                left++;
            }
            else if(sum>0){
                right--;
            }
            else{
                result.add(Arrays.asList(nums[chosenElementsIndex],nums[left],nums[right]));
                do{
                    left++;
                }
                while (left<right && nums[left]==nums[left-1]);
            }
        }
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxArea = 0;
        int area;
        while(left<right){
            area=Math.min(height[left],height[right])*(right-left);
            maxArea = Math.max(area,maxArea);
            if (height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }

    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] dp = new int[text1.length()+1][text2.length()+1];
//        for (int i = 0; i < text1.length(); i++) {
//            for (int j = 0; j < text2.length(); j++) {
//                if(text1.charAt(i)==text2.charAt(j)){
//                    dp[i+1][j+1] = 1+dp[i][j];
//                }
//                else{
//                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
//                }
//            }
//        }
//        return dp[text1.length()][text2.length()];
        dp = new int[text1.length()][text2.length()];
        for (int[] subDP:dp){
            Arrays.fill(subDP,-1);
        }
        return topDownApproach(text1,text2,0,0);
    }
    private int topDownApproach(String text1, String text2, int char1Index, int char2Index){
        if (char1Index>=text1.length() || char2Index>=text2.length())return 0;
        if (dp[char1Index][char2Index]!=-1)return dp[char1Index][char2Index];
        int longestSequence = text1.charAt(char1Index)==text2.charAt(char2Index)?
                1 + topDownApproach(text1,text2,char1Index+1,char2Index+1):
                Math.max(topDownApproach(text1,text2,char1Index+1,char2Index),
                        topDownApproach(text1,text2,char1Index,char2Index+1));
        dp[char1Index][char2Index] = longestSequence;
        return longestSequence;
    }

    boolean[] wordBreakDP;
    boolean[] wordBreakVisited;
    public boolean wordBreak(String s, List<String> wordDict) {
        wordBreakDP = new boolean[s.length()];
        wordBreakVisited = new boolean[s.length()];
        return wordBreakerDP(s,wordDict,0);
    }
    private boolean wordBreakerDP(String s, List<String> wordDict, int startingIndex){
        if (startingIndex==s.length())return true;
        if (wordBreakVisited[startingIndex])return wordBreakDP[startingIndex];
        wordBreakVisited[startingIndex] = true;
        for (String word:wordDict){
            if (s.substring(startingIndex).startsWith(word) && wordBreakerDP(s,wordDict,startingIndex+word.length())){
                wordBreakDP[startingIndex] = true;
                return true;
            }
        }
        wordBreakDP[startingIndex] = false;
        return false;
    }

    int numDecodingsDP[];
    public int numDecodings(String s) {
//        int[] dp = new int[s.length()+1];
//        dp[s.length()]=1;
//        dp[s.length()-1]= s.charAt(s.length()-1)=='0'?0:1;
//        for (int i = s.length()-2; i >=0 ; i--) {
//            if(s.charAt(i)=='0'){
//                dp[i] = 0;
//            }
//            else if(s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7'){
//                dp[i] = dp[i+1] + dp[i+2];
//            }
//            else{
//                dp[i] = dp[i+1];
//            }
//        }
//        return dp[0];
        numDecodingsDP = new int[s.length()];
        Arrays.fill(numDecodingsDP,-1);
        return topDownApproach(s,0);
    }
    public int topDownApproach(String s, int startingIndex){
        if(startingIndex>=s.length())return 1;
        if (s.charAt(startingIndex)=='0')return 0;
        if (numDecodingsDP[startingIndex]!=-1)return numDecodingsDP[startingIndex];
        char c = s.charAt(startingIndex);
        int possibleDecodings;
        if ((startingIndex+1<s.length()) && (c=='1'||c=='2' && s.charAt(startingIndex+1)<'7')){
            possibleDecodings = topDownApproach(s,startingIndex+1) + topDownApproach(s,startingIndex+2);
        }
        else{
            possibleDecodings = topDownApproach(s,startingIndex+1);
        }
        numDecodingsDP[startingIndex] = possibleDecodings;
        return possibleDecodings;
    }

    public static void main(String[] args) {
        TrianglzPreperation tp = new TrianglzPreperation();
    }
}
