package Contests;

import java.util.*;

public class LeetCodeBiWeeklyContest95 {

    private boolean Bulky(int length, int width, int height){
        int bulkDimension = 10000;
        double volMin = Math.pow(10,9);
        double volume = length*width;
        volume*=height;
        return length>=bulkDimension || width>=bulkDimension || height>=bulkDimension ||
                volume>=volMin;
    }
    private boolean Heavy(int mass){
        return mass>=100;
    }
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = Bulky(length,width,height);
        boolean heavy = Heavy(mass);
        if(bulky==heavy){
            return !bulky? "Neither":"Both";
        }
        return bulky? "Bulky":"Heavy";
    }
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    public static class DataStream {
        int lastAddedValue;
        int lastAddedValueCount;
        int value;
        int k;
        public DataStream(int value, int k) {
            this.k=k;
            this.value=value;
            lastAddedValueCount=0;
        }

        public boolean consec(int num) {
            if(num==lastAddedValue){
                lastAddedValueCount++;
            }
            else {
                lastAddedValueCount = 1;
                lastAddedValue = num;
            }
            return lastAddedValue==value &&lastAddedValueCount>=k;
        }
    }

    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////

    public int xorBeauty(int[] nums) {
        int result=0;
        for (int num:nums){
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCodeBiWeeklyContest95 lc95 = new LeetCodeBiWeeklyContest95();
        int[] nums = {15,45,20,2,34,35,5,44,32,30};
        System.out.println(lc95.xorBeauty(nums));
    }
}

