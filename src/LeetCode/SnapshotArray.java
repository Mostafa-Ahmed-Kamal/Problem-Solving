package LeetCode;

import java.util.TreeMap;

class SnapshotArray {
    int snapShotID = 0;
    TreeMap<Integer,Integer>[] valuesHistory;
    public SnapshotArray(int length) {
        valuesHistory = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            valuesHistory[i] = new TreeMap<>();
            valuesHistory[i].put(0,0);
        }
    }

    public void set(int index, int val) {
        valuesHistory[index].put(snapShotID,val);
    }

    public int snap() {
        return snapShotID++;
    }

    public int get(int index, int snap_id) {
        // floor entry returns the greatest key less than or equal snap_id;
        return valuesHistory[index].floorEntry(snap_id).getValue();
    }
}