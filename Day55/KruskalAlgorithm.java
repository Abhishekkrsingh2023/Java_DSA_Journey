import DisjointSet.Dset;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalAlgorithm {
    // edge class for the graph
    public static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge other){
            return Integer.compare(this.weight, other.weight);
        }
    }
    // main Kruskal's Algorithm
    private static int getMST(PriorityQueue<Edge> pq, int V) {
        Dset set = new Dset(V);
        int cost = 0;
        int edgeNo = 0;
        // traversing the edges int the min order
        while(!pq.isEmpty()) {
            Edge curr = pq.remove();
            int u = curr.src;
            int v = curr.dest;
            int w = curr.weight;
            if(set.find(u) == set.find(v)) continue;
            set.union(u,v);
            cost += w;
            edgeNo += 1;
            // mst has V-1 edges
            if(edgeNo == V-1) break;
        }
        return cost;
    }
    public static void main(String[] args) {
        int V = 6; // number of vertex;
        Dset set = new Dset(V);
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,2,5));
        edges.add(new Edge(1,2,2));
        edges.add(new Edge(2,5,2));
        edges.add(new Edge(2,4,6));
        edges.add(new Edge(2,3,3));
        edges.add(new Edge(3,4,3));
        edges.add(new Edge(5,4,3));
        // added all the edge list to the priorityQueue a.k.a minHeap
        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        int cost = getMST(pq,V);
        System.out.println(cost);
    }
}
