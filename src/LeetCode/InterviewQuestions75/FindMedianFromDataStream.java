package LeetCode.InterviewQuestions75;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    public static class MedianFinder{
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;
        public MedianFinder() {
            /**
             * The minHeap represents the big half of the sorted array where it contains the top n/2 values
             * The maxHeap represents the small half of the sorted array where it contains the least n/2 values
             */
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if(!minHeap.isEmpty() && num<minHeap.peek()){
                maxHeap.add(num);
            }
            else{
                minHeap.add(num);
            }
            /**
             * to re-balance the heaps, we take the root of the min tree which represents the smallest value in the largest half
             * and put it in the maxHeap tree which represents the smallest part of the array
             */
            if(minHeap.size()>maxHeap.size()+1){
                maxHeap.add(minHeap.poll());
            }
            else if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if(minHeap.isEmpty() && maxHeap.isEmpty())return 0;
            if(minHeap.size()==maxHeap.size())return (double)(minHeap.peek()+maxHeap.peek())/2;
            if(minHeap.size()>maxHeap.size())return minHeap.peek();
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        System.out.println(mf.findMedian());
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());

    }
}
