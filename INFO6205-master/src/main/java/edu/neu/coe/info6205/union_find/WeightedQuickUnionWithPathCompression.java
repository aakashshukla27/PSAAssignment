package edu.neu.coe.info6205.union_find;

public class WeightedQuickUnionWithPathCompression {
    private int[] id;
    private int[] size;
    private int count;

    public WeightedQuickUnionWithPathCompression(int n){
        count = n;
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
        validate(p);
        int root = p;
        while (root != id[root])
            root = id[root];
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("Error");
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        if (size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
    public int components() {
        return count;
    }


}
