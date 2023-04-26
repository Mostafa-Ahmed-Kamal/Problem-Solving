package LeetCode;

public class DetectCapital {
    private boolean smallLetter(char letter){
        return letter>='a' && letter<='z';
    }
    private boolean capitalLetter(char letter){
        return letter>='A' && letter<='Z';
    }
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        int smallMinusCapital = 0;
        for(char letter:word.toCharArray()){
            smallMinusCapital += smallLetter(letter)?1:-1;
        }
        return Math.abs(smallMinusCapital)==word.length() ||
                (smallMinusCapital==word.length()-2 && capitalLetter(word.charAt(0)));
    }

    public static void main(String[] args) {
        DetectCapital dc = new DetectCapital();
        String word = "Ehet";
        System.out.println(dc.detectCapitalUse(word));
    }
}
