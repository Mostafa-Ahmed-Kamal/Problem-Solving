package LeetCode;

public class RemovingStarsFromAString {
    public String removeStars(String s) {
        int startCount = 0;
        StringBuilder result = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)=='*'){
                startCount++;
                continue;
            }
            if (startCount>0){
                startCount--;
                continue;
            }
            result.insert(0,s.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromAString rs = new RemovingStarsFromAString();
        String s = "leet**cod*e";
        System.out.println(rs.removeStars(s));
    }

}
