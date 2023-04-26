package LeetCode;

public class RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int aWidth = ax2-ax1;
        int aHeight = ay2-ay1;
        int bWidth = bx2-bx1;
        int bHeight = by2-by1;
        int overlapX = Math.max(0,aWidth+bWidth-(Math.max(ax2,bx2)-Math.min(ax1,bx1)));
        int overlapY = Math.max(0,aHeight+bHeight-(Math.max(ay2,by2)-Math.min(ay1,by1)));
        System.out.println(ax2-bx1);
        System.out.println("A:"+aWidth*aHeight+"\nB:"+bWidth*bHeight+"\nOverlap:"+overlapX*overlapY);
        return aWidth*aHeight + bWidth*bHeight - overlapX*overlapY;
    }

    public static void main(String[] args) {
        RectangleArea ra = new RectangleArea();
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        System.out.println(ra.computeArea(ax1, ay1, ax2, ay2, bx1, by1,bx2, by2));
    }

}
