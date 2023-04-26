package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DesignBrowserHistory {
    class BrowserHistory {
        Stack<String> undo;
        Stack<String> redo;
        String currentPage;
        public BrowserHistory(String homepage) {
            undo = new Stack<>();
            redo = new Stack<>();
            currentPage = homepage;
        }

        public void visit(String url) {
            redo.clear();
            undo.add(currentPage);
            currentPage = url;
        }

        public String back(int steps) {
            while(!undo.isEmpty() && steps>0) {
                redo.add(currentPage);
                currentPage = undo.pop();
                steps--;
            }
            return currentPage;
        }

        public String forward(int steps) {
            while(!redo.isEmpty() && steps>0) {
                undo.add(currentPage);
                currentPage = redo.pop();
                steps--;
            }
            return currentPage;
        }
    }
}
