package LeetCode;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile:piles){
            maxPile = Math.max(maxPile,pile);
        }
        int minEatingRatio = 1;
        int maxEatingRatio = (int) (maxPile*Math.ceil((double)piles.length/h));
        while(minEatingRatio<maxEatingRatio){
            int midEatingRatio = (minEatingRatio+maxEatingRatio)/2;
            if(isEnoughEatingRatio(piles,h,midEatingRatio)){
                maxEatingRatio = midEatingRatio;
            }
            else{
                minEatingRatio = midEatingRatio+1;
            }
        }
        return minEatingRatio;
    }
    private boolean isEnoughEatingRatio(int[] piles, int h, int eatingRatio){
        int totalHours=0;
        for (int pile:piles){
            totalHours+= Math.ceil((double)pile/eatingRatio);
            if(totalHours>h)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();
        int piles[] = {3,6,7,11}, h = 8;
        System.out.println(keb.minEatingSpeed(piles,h));
    }
}
