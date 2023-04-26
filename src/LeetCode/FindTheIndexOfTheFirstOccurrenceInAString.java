package LeetCode;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if(needle.length()>haystack.length())return 0;
        int needleIndex=0;
        for (int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(needleIndex))needleIndex++;
            else {
                i-=needleIndex;
                needleIndex = 0;
            }
            if(needleIndex>=needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString ffo = new FindTheIndexOfTheFirstOccurrenceInAString();
        String haystack = "mississippi", needle = "issip";
        System.out.println(ffo.strStr(haystack,needle));
    }
}
