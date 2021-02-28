package edu.neu.coe.info6205.union_find;

public class WeightQuickUnionHeight {
    private int[] id;
    private int[] depth;
    private int count;

    public WeightQuickUnionHeight(int n){
        count = n;
        id = new int[n];
        depth = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            depth[i] = 0;
        }
    }
    public int count(){
        return count;
    }

    private void validate(int p){
        int n = id.length;
        if(p < 0 || p > n){
            throw new IllegalArgumentException("Limit Error");
        }
    }

    public int find(int p){
        validate(p);
        while(p != id[p]){
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;
        if      (depth[i] < depth[j]) id[i] = j;
        else if (depth[i] > depth[j]) id[j] = i;
        else {
            id[j] = i;
            depth[i]++;
        }
        count--;
    }
    public boolean isCycle(){
        boolean returnValue = true;
        int firstValue = id[0];
        for (int i = 1; i < id.length; i++) {
            if(id[i]!=firstValue){
                returnValue = false;
                break;
            }
        }
        return returnValue;
    }
}
