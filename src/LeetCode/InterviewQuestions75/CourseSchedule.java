package LeetCode.InterviewQuestions75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length==0) return true;
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int[] prequisite : prerequisites) {
            map.get(prequisite[0]).add(prequisite[1]);
        }

        for (int[] prequisite : prerequisites) {
            if(!canFinishRecursive(prequisite[0])){
                return false;
            }
        }
    return true;
    }

    public boolean canFinishRecursive(int currentCourse) {
        if(visited.contains(currentCourse)) return map.get(currentCourse).size()==0;
        visited.add(currentCourse);
        boolean courseSatisfied = true;
        for (int course: map.get(currentCourse)){
            courseSatisfied &= canFinishRecursive(course);
        }
        if(courseSatisfied)map.get(currentCourse).clear();
        return courseSatisfied;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int prequisites[][] = {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        int numCourses = 20;
        System.out.println(cs.canFinish(numCourses,prequisites));
    }
}