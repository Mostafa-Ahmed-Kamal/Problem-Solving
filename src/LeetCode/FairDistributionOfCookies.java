package LeetCode;

public class FairDistributionOfCookies {
    int[] children;
    public int distributeCookies(int[] cookies, int k) {
        children = new int[k];
        return distributeCookiesDP(cookies,0,0);
    }
    private int distributeCookiesDP(int[] cookies, int cookieBagID, int heaviestBag){
        if(cookieBagID>=cookies.length)return heaviestBag;
        int minUnfairness = Integer.MAX_VALUE;
        for(int i=0; i<children.length; i++){
            children[i]+=cookies[cookieBagID];
            minUnfairness = Math.min(minUnfairness,distributeCookiesDP(cookies,cookieBagID+1,Math.max(children[i],heaviestBag)));
            children[i]-=cookies[cookieBagID];
        }
        return minUnfairness;
    }

    public static void main(String[] args) {
        FairDistributionOfCookies fc = new FairDistributionOfCookies();
        int cookies[] = {8,15,10,20,8}, k = 2;
        System.out.println(fc.distributeCookies(cookies,k));
    }
}
