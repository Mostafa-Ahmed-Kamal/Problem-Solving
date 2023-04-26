package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {
    public class Task{
        int enqueueTime;
        int processingTime;
        int index;
        public Task(int enqueueTime,int processingTime, int index){
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
            this.index = index;
        }
        public int getEnqueueTime(){
            return enqueueTime;
        }
        public int getProcessingTime(){
            return processingTime;
        }
        public int getIndex(){
            return index;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] result = new int[n];
        PriorityQueue<Task> remainingTasks = new PriorityQueue<>(Comparator.comparingInt(Task::getEnqueueTime));
        PriorityQueue<Task> pendingTasks = new PriorityQueue<>(Comparator.comparingInt(Task::getProcessingTime).thenComparingInt(Task::getIndex));
        for (int i=0; i<n; i++){
            remainingTasks.add(new Task(tasks[i][0],tasks[i][1],i));
        }
        int time = 0;
        int resultIterator=0;
        while(!remainingTasks.isEmpty() || !pendingTasks.isEmpty()){
            while(!remainingTasks.isEmpty() && remainingTasks.peek().enqueueTime<=time){
                pendingTasks.add(remainingTasks.poll());
            }
            if(remainingTasks.isEmpty() && pendingTasks.isEmpty())continue;
            if(pendingTasks.isEmpty()){
                time = remainingTasks.peek().enqueueTime;
                continue;
            }
            Task chosenTask = pendingTasks.poll();
            result[resultIterator] = chosenTask.index;
            resultIterator++;
            time += chosenTask.processingTime;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleThreadedCPU stc = new SingleThreadedCPU();
        int[][] tasks = {{428,324},{1,2},{844,657},{1,2}};
        System.out.println(Arrays.toString(stc.getOrder(tasks)));
    }
}
