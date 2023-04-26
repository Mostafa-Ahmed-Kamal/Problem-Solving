package LeetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numberOfRooms = rooms.size();
        if(numberOfRooms==0)return true;
        int numberOfOpenedRooms = 0;
        boolean[] visited = new boolean[numberOfRooms];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){
            if(numberOfRooms == numberOfOpenedRooms) return true;
            int roomId = stack.pop();
            if(visited[roomId])continue;
            List<Integer> room = rooms.get(roomId);
            visited[roomId] = true;
            numberOfOpenedRooms++;
            for(int key:room){
                stack.push(key);
            }
        }
        return numberOfRooms == numberOfOpenedRooms;
    }

    public static void main(String[] args) {
        KeysAndRooms kr = new KeysAndRooms();
        List<List<Integer>> rooms = new LinkedList();
        rooms.add(new LinkedList(Collections.singleton(new int[]{1,3})));
        rooms.add(new LinkedList(Collections.singleton(new int[]{3,0,1})));
        rooms.add(new LinkedList(Collections.singleton(new int[]{2})));
        rooms.add(new LinkedList(Collections.singleton(new int[]{0})));
        System.out.println(kr.canVisitAllRooms(rooms));
    }
}
