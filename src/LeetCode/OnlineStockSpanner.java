package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class OnlineStockSpanner {
    static class StockSpanner {
        private class spanInfo{
            int price;
            int nextLength;
            public spanInfo(int price, int nextLength){
                this.price = price;
                this.nextLength = nextLength;
            }
        }
        private Stack<spanInfo> span;
        public StockSpanner() {
            span = new Stack<>();
        }

        public int next(int price) {
            int count =1;
            while(!span.isEmpty() && span.peek().price<=price){
                count+= span.pop().nextLength;
            }
            span.push(new spanInfo(price,count));
            return count;
        }
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();
        System.out.println(sp.next(32));
        System.out.println(sp.next(82));
        System.out.println(sp.next(73));
        System.out.println(sp.next(99));
        System.out.println(sp.next(91));
//        System.out.println(sp.next(32));

    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
