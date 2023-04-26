package Contests;

import java.util.*;

public class LeetCodeBiWeeklyContest91 {

    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Double> result = new HashSet<>();
        int start=0, end=nums.length-1;
        while(start<=end){
            result.add((double)(nums[start]+nums[end])/2);
            start++;
            end--;
        }
        return result.size();
    }
    HashMap<Integer,Integer> visited;
    public int countGoodStrings(int low, int high, int zero, int one) {
        visited = new HashMap<>();
        int count=0;
        for (int i = low; i <= high ; i++) {
            count= (int) ((count%(Math.pow(10,9)+7)+goodStringsDFS(i,zero,one)%(Math.pow(10,9)+7))%(Math.pow(10,9)+7));
        }
        return (int) (count%(Math.pow(10,9)+7));
    }
    public int goodStringsDFS(int leftLength, int zero, int one){
        if(leftLength<0)return 0;
        if(leftLength==0)return 1;
        if(visited.containsKey(leftLength)) return visited.get(leftLength);
        int result = (int) ((goodStringsDFS(leftLength-zero, zero, one)%(Math.pow(10,9)+7)+goodStringsDFS(leftLength-one, zero, one)%(Math.pow(10,9)+7))%(Math.pow(10,9)+7));
        visited.put(leftLength,result);
        return result;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        int maxCount = Integer.MIN_VALUE;
        int matrix[][] = constructTree(edges, n);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0}); //node,currentCost
        while(!queue.isEmpty()){
            int AliceState[] = queue.poll();
            if(AliceState[0]==bob){
                AliceState[1] += amount[AliceState[0]]/2;
            }
            else{
                AliceState[1] += amount[AliceState[0]];
            }
            amount[AliceState[0]] = 0;
            amount[bob] = 0;
            for (int i = 0; i < n; i++) {
                if(matrix[i][bob]==1){
                    bob = i;
                    break;
                }
            }
            boolean zeroStatesAdded = true;
            for (int i = 0; i < n; i++) {
                if(matrix[AliceState[0]][i]==1){
                    zeroStatesAdded = false;
                    queue.add(new int[] {i,AliceState[1]});
                }
            }
            if(zeroStatesAdded){
                maxCount = Math.max(maxCount,AliceState[1]);
            }
        }
        return maxCount;
    }
    public int[][] constructTree(int[][] edges, int n){
        int matrix[][] = new int[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int[] edge:edges){
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }
        while(!queue.isEmpty()){
            int parent = queue.poll();
            for (int i = 0; i < n; i++) {
                if(matrix[parent][i]==1){
                    queue.add(i);
                    matrix[i][parent]=0;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        LeetCodeBiWeeklyContest91 lc91 = new LeetCodeBiWeeklyContest91();
//        int nums[] = {4,1,4,0,3,5};
//        System.out.println(lc91.distinctAverages(nums));
//        System.out.println(lc91.countGoodStrings(1 ,100000 ,1,1));
//        System.out.println(Math.pow(10,9)+7);
        int edges[][] = {{0,2},{0,5},{1,3},{1,5},{2,4}};
        int bob = 4;
        int amount[] = {5018,8388,6224,3466,3808,3456};
        System.out.println(lc91.mostProfitablePath(edges, bob, amount)); // 20328
    }
}
