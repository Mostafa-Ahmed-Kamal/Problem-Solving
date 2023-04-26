package LeetCode;

public class MakeTheStringGreat {

    public String makeGood(String s) {
        for (int i = 0; i < s.length()-1; i++) {
            if(Math.abs(s.charAt(i)-s.charAt(i+1))==32){
                s = s.substring(0,i)+s.substring(i+2);
                i = Math.max(i-2,-1);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        MakeTheStringGreat msg = new MakeTheStringGreat();
        System.out.println(msg.makeGood("leEeetCode"));
        // "leetcode"
        System.out.println(msg.makeGood("abBAcC"));
        // ""
        System.out.println(msg.makeGood("s"));
        // "s"
        System.out.println(msg.makeGood("IOFWSVFWLQiZdOuTNLDarLVggWUbyvIEWFyCTycPWlSyDEDpllKbJNXdyDpVqAhfDJnkhEJQR"));
        //"IOFWSVFWLQiZdOuTNLDarLVggWUbyvIEWFyCTycPWlSyDEDpllKbJNXdyDpVqAhfDJnkhEJQR"
    }

}
