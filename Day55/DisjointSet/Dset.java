package DisjointSet;

public class Dset {
    private int V;
    private int[] parent;
    private int[] rank;

    public Dset(int V) {
        this.V = V;
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            if (rank[px] > rank[py])
                parent[py] = px;
            else if (rank[px] < rank[py])
                parent[px] = py;
            else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
