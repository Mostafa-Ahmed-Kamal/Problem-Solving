package LeetCode;

import java.util.Stack;

public class StringCompression {
    int lastWrittenIndex,repetitionCount;
    char currentChar;
    public int compress(char[] chars) {
        if(chars.length==0)return 0;
        lastWrittenIndex = -1;
        currentChar = chars[0];
        repetitionCount = 0;
        for (char c:chars){
            if(c==currentChar)repetitionCount++;
            else{
                writeCompression(chars);
                repetitionCount=1;
                currentChar=c;
            }
        }
        writeCompression(chars);
        return lastWrittenIndex+1;
    }
    private void writeCompression(char[] chars){
        chars[++lastWrittenIndex]=currentChar;
        String count = String.valueOf(repetitionCount);
        if(repetitionCount>1) {
            for (char c:count.toCharArray()) {
                chars[++lastWrittenIndex] = c;
            }
        }
    }

    public static void main(String[] args) {

    }

}
