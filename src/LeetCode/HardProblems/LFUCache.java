package LeetCode.HardProblems;

import java.util.*;

public class LFUCache {
    HashMap<Integer,Integer> cache;
    HashMap<Integer,Integer> keysFrequency;
    HashMap<Integer,LinkedHashSet<Integer>> frequencyKeys;
    int capacity;
    int minFrequency;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFrequency = 0;
        cache = new HashMap<>();
        keysFrequency = new HashMap<>();
        frequencyKeys = new HashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int frequency = keysFrequency.get(key);
        frequencyKeys.get(frequency).remove(key);
        if (frequency==minFrequency && frequencyKeys.get(frequency).isEmpty()) {
            frequencyKeys.remove(frequency);
            minFrequency++;
        }
        updateFrequency(key,frequency+1);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(capacity==0)return;
        if(cache.containsKey(key)){
            cache.put(key,value);
            get(key);
            return;
        }
        if(cache.size() >= capacity) {
            int LFUKey = frequencyKeys.get(minFrequency).iterator().next();
            frequencyKeys.get(minFrequency).remove(LFUKey);
            cache.remove(LFUKey);
        }
        minFrequency = 1;
        updateFrequency(key,1);
        cache.put(key,value);
    }
    private void updateFrequency(int key, int frequency){
        frequencyKeys.putIfAbsent(frequency,new LinkedHashSet<>());
        frequencyKeys.get(frequency).add(key);
        keysFrequency.put(key,frequency);
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.put(3,3);
        lfuCache.put(3,33);
        // 1 is now not the least frequently used
        System.out.println(lfuCache.get(1));
        lfuCache.put(4,4);
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
    }
}
