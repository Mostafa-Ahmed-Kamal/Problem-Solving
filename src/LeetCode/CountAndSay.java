package LeetCode;

import java.util.Arrays;

public class CountAndSay {
    public String countAndSay(int n){
        String sayI = "1";
        for (int i = 1; i < n; i++) {
            sayI = say(sayI);
        }
        return sayI;
    }
    private String say(String n){
        String[] sayN = n.split("(?<=(.))(?!\\1)");
        StringBuilder result = new StringBuilder("");
        for (String s:sayN){
            result.append(s.length()+""+s.charAt(0));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CountAndSay cs = new CountAndSay();
        System.out.println(cs.countAndSay(4));
    }
}
