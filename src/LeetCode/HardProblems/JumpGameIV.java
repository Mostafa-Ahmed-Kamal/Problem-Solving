package LeetCode.HardProblems;

import java.util.*;

public class JumpGameIV {
    HashSet<Integer> visitedValues;
    boolean[] visitedIndex;
    Queue<Integer> queue;
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        visitedValues = new HashSet<>();
        visitedIndex = new boolean[arr.length];
        queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.putIfAbsent(arr[i],new LinkedList<>());
            hashMap.get(arr[i]).add(i);
        }
        queue.add(0);
        visitedIndex[0] = true;
        int iteration = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int index = queue.poll();
                if(index==arr.length-1)return iteration;
                addToQueue(index+1,arr);
                addToQueue(index-1,arr);
                if(visitedValues.contains(arr[index]))continue;
                for (int sameValueIndex:hashMap.get(arr[index])){
                    addToQueue(sameValueIndex,arr);
                }
                visitedValues.add(arr[index]);
            }
            iteration++;
        }
        return arr.length-1;
    }
    private void addToQueue(int index,int[] arr){
        if(!(outOfBounds(index,arr) || visitedIndex[index])){
            queue.add(index);
            visitedIndex[index]=true;
        }
    }
    private boolean outOfBounds(int index, int[] arr){
        return index<0 || index>=arr.length;
    }

    public static void main(String[] args) {
        JumpGameIV jg4 = new JumpGameIV();
        int[] arr = {7,6,9,6,9,6,9,7};
        System.out.println(jg4.minJumps(arr));
    }
}
