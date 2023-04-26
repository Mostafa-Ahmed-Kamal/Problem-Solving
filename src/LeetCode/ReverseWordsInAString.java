package LeetCode;

import java.util.Arrays;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String words[] = s.split("\\s+");
        int start = words[0]==""?1:0;
        System.out.println(Arrays.toString(words));
        StringBuilder result = new StringBuilder(words[start]);
        for (int i = start+1; i < words.length; i++) {
            result.insert(0,words[i]+" ");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString rs = new ReverseWordsInAString();
        String s = "   hey there i   am using whatsapp   ";
        System.out.println("words:"+rs.reverseWords(s));
    }
}
