package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule {
    int[] courseState;
    boolean[] visited;
    // -1 false, 1 true, 0 unvisited
    public boolean canFinish(int numCourses, int[][] prerequisites){
        courseState = new int[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] prerequisite:prerequisites){
            graph[prerequisite[0]].add(prerequisite[1]);
        }
        for (int i = 0; i < graph.length; i++) {
            if (!canFinishCourse(graph,i)){
                return false;
            }
        }
        return true;

    }
    private boolean canFinishCourse(List<Integer>[] graph, int nodeID){
        if (courseState[nodeID]!=0)return courseState[nodeID]==1;
        if (visited[nodeID])return false;
        visited[nodeID]=true;
        for (int neighbor:graph[nodeID]) {
            if (!canFinishCourse(graph, neighbor)) {
                courseState[nodeID]=-1;
                return false;
            }
        }
        visited[nodeID]=false;
        courseState[nodeID]=1;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(cs.canFinish(numCourses,prerequisites));
    }
}
