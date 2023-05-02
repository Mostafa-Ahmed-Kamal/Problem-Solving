package LeetCode.Utils;

public class UnionFind {
    int[] representative;
    int[] groupSize;
    int individualComponents;
    public UnionFind(int size){
        this.individualComponents = size;
        representative = new int[size];
        groupSize = new int[size];
        for (int i = 0; i < size; i++) {
            representative[i] = i;
            groupSize[i] = 1;
        }
    }
    public int findRepresentative(int id){
        if (representative[id]==id)return id;
        return representative[id] = findRepresentative(representative[id]);
    }
    public int merge(int x, int y){
        y = findRepresentative(y);
        x = findRepresentative(x);
        if (x==y)return 0;
        if (y<x){
            representative[x] = y;
            groupSize[y] += groupSize[x];

        }
        else{
            representative[y] = x;
            groupSize[x] += groupSize[y];
        }
        individualComponents--;
        return 1;
    }
    public boolean isConnected(){
        return individualComponents==1;
    }
}
