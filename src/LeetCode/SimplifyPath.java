package LeetCode;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] directories = path.split("/");
        for (String directory:directories){
            if (directory.equals("..")){
                if (!stack.isEmpty())stack.pop();
                continue;
            }
            if (directory.equals(".") || directory.equals(""))continue;
            String simplifiedDirectory = "/"+directory.replaceAll("/","");
            stack.add(simplifiedDirectory);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            String directory = stack.pop();
            result.insert(0,directory);
        }
        if (result.length()==0)return "/";
        return result.toString();
    }
}
