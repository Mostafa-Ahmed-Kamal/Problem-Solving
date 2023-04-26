package LeetCode;

public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        int sIndex=0, pIndex=0, starIndex=-1, matchingStart=0;
        int sLength = s.length(), pLength = p.length();
        while(sIndex<sLength){
            char sChar = s.charAt(sIndex);
            // if characters match move both pointers forward
            if (pIndex<pLength && (p.charAt(pIndex) == '?' || sChar == p.charAt(pIndex))) {
                pIndex++;
                sIndex++;
            }
            // if the current p is a * mark its index, update pIndex and move forward
            else if (pIndex<pLength && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchingStart = sIndex;
                pIndex++;
            }
            // if the current characters are not a match however, we have a start in the string, then the first match of the start was wrong
            // go back and adjust it by 1
            else if(starIndex!=-1){
                sIndex = ++matchingStart;
                pIndex = starIndex + 1;
            }
            // no stars nor matches? return false
            else return false;
        }
        // if s ended but p still have values, unless these values are *'s return false
        for (int i = pIndex; i < p.length(); i++) {
            if(p.charAt(i)!='*')return false;
        }
        return true;
    }

    public static void main(String[] args) {
        WildCardMatching wcm = new WildCardMatching();
        String s = "aaaba";
        String p = "*a";
        System.out.println(wcm.isMatch(s,p));
    }
}
