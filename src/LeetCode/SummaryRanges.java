package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int start,end;
        List<String> ranges = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            start = nums[i];
            end = nums[i];
            while (i<nums.length && ((nums[i]-end)==0 || (nums[i]-end)==1)){
                end = nums[i];
                i++;
            }
            i--;
            addRange(start,end,ranges);
        }
        return ranges;
    }
    public void addRange(int start, int end, List<String> ranges){
        String range = start==end?""+start: start+"->"+end;
        ranges.add(range);
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        int[] nums = {0,1,2,4,5,7};
        System.out.println(sr.summaryRanges(nums));
    }
}
