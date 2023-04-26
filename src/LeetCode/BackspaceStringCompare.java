package LeetCode;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        return countString(s).equals(countString(t));
    }
    private String countString(String s){
        StringBuilder result = new StringBuilder();
        int erasedCount = 0;
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c=='#'){
                erasedCount++;
            }
            else if(erasedCount>0){
                erasedCount--;
            }
            else {
                result.insert(0,c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare bsc = new BackspaceStringCompare();
        String s = "bxj##tw" ,t = "bxj###tw";
        System.out.println(bsc.backspaceCompare(s,t));
    }
}
