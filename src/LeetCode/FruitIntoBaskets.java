package LeetCode;

import java.util.HashMap;

public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> fruitsInBasket = new HashMap<>();
        int start=0, end=0;
        int fruitsTypeCount=0;
        int maxValue=0;
        int currentMax=0;
        while(end<fruits.length){
            if(fruitsTypeCount==2 && fruitsInBasket.getOrDefault(fruits[end],0)==0){
                while(start<end && fruitsTypeCount==2){
                    int fruitCount = fruitsInBasket.get(fruits[start])-1;
                    if(fruitCount==0) {
                        fruitsTypeCount--;
                    }
                    fruitsInBasket.put(fruits[start],fruitCount);
                    currentMax--;
                    start++;
                }
            }
            int fruitCount = fruitsInBasket.getOrDefault(fruits[end],0);
            if(fruitCount==0)fruitsTypeCount++;
            fruitsInBasket.put(fruits[end],fruitCount+1);
            currentMax++;
            maxValue = Math.max(maxValue,currentMax);
            end++;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fib = new FruitIntoBaskets();
        int[] fruits = {1,2,3,2,2};
        System.out.println(fib.totalFruit(fruits));
    }
}
