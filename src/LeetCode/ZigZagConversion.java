package LeetCode;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows<2)return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int rowsIndex = 0;
        int direction = 1;
        for (char c:s.toCharArray()){
            rows[rowsIndex].append(c);
            if(rowsIndex==numRows-1)direction=-1;
            if(rowsIndex==0)direction=1;
            rowsIndex += direction;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb:rows){
            result.append(sb.toString());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("PAYPALISHIRING",3));
    }
}
