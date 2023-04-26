package LeetCode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 *
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 * Example 2:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 0
 * Output: 6
 * Explanation: On this case any permutation of size 6 would work since n = 0.
 * ["A","A","A","B","B","B"]
 * ["A","B","A","B","A","B"]
 * ["B","B","B","A","A","A"]
 * ...
 * And so on.
 * Example 3:
 *
 * Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
 * Output: 16
 * Explanation:
 * One possible solution is
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> taskMap = new HashMap<>();
        // locate each task with its time
        for(Character task:tasks){
            taskMap.put(task,taskMap.getOrDefault(task,0)+1);
        }
        // add tasks to priority queue by their time (tasks with big timers receive a higher priority)
        Queue<Integer> queue = new PriorityQueue<>((x,y)->y-x); //priority queue is ascending order
        queue.addAll(taskMap.values());

        HashMap<Integer,Integer> coolDownTime = new HashMap<>();
        int time=0;
        int remainingTime;
        while(!queue.isEmpty() || !coolDownTime.isEmpty()){
            if(coolDownTime.containsKey(time)){
                queue.add(coolDownTime.get(time));
                coolDownTime.remove(time);

            }
            if(!queue.isEmpty()){
                remainingTime = queue.poll();
                if (remainingTime>1) coolDownTime.put(time+n+1,remainingTime-1);
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};//output: 16
        System.out.println(ts.leastInterval(tasks,2));

    }
}
