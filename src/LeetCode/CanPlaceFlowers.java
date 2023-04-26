package LeetCode;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if(n<=0)return true;
            if (canAddOne(flowerbed, i)){
                flowerbed[i] = 1;
                n-=1;
            }
        }
        return n<=0;
    }
    private boolean canAddOne(int[] flowerbed, int i){
        boolean leftIsEmpty = i==0 || flowerbed[i-1]==0;
        boolean rightIsEmpty = i==flowerbed.length-1 || flowerbed[i+1]==0;
        return leftIsEmpty && flowerbed[i]==0 && rightIsEmpty;
    }
    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int flowerbed[] = {1,0,0,0,1}, n = 1;
        System.out.println(cpf.canPlaceFlowers(flowerbed,n));
    }
}
