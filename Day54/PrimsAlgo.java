import java.util.*;

public class PrimsAlgo {
    // Node class for heap
    static class Node implements Comparable<Node> {
        int node;
        int parent;
        int weight;

        public Node(int node, int parent, int weight) {
            this.node = node;
            this.parent = parent;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    // edge class
    static class Edge {
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // graph class
    static class Graph {
        int V;
        List<Edge> adj[];
        int[] parent;

        public Graph(int vertices) {
            this.V = vertices;
            this.adj = new ArrayList[V];
            parent = new int[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        // adds the edge
        public void addEgde(int src, int dest, int weight) {
            adj[src].add(new Edge(dest, weight));
            adj[dest].add(new Edge(src, weight));
        }

        public int PrimsCost() {
            // parent and mst
            boolean[] mst = new boolean[V];
            Arrays.fill(parent, -1); // parent initially -1
            PriorityQueue<Node> heap = new PriorityQueue<>();
            // start node
            heap.add(new Node(0, -1, 0));
            int cost = 0;
            while (!heap.isEmpty()) {
                Node n = heap.poll();
                int node = n.node;
                int weight = n.weight;
                int pr = n.parent;
                if (!mst[node]) {
                    mst[node] = true;  // Mark node as visited
                    cost += weight;    // Add weight to MST cost
                    parent[node] = pr; // Marking the parent
                    // Traverse neighbors
                    for (Edge nbr : adj[node]) {
                        if (!mst[nbr.dest]) {
                            heap.add(new Node(nbr.dest, node, nbr.weight));
                        }
                    }
                }
            }
            return cost;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEgde(0, 1, 3);
        graph.addEgde(0, 2, 5);
        graph.addEgde(1, 2, 2);
        graph.addEgde(1, 3, 6);
        graph.addEgde(1, 4, 8);
        graph.addEgde(2, 3, 1);
        graph.addEgde(2, 5, 4);
        graph.addEgde(3, 5, 11);
        graph.addEgde(5, 4, 6);
        System.out.println(graph.PrimsCost());
        int i=0;
        for(int ele : graph.parent) {
            System.out.println(i+" <-> "+ele);
            i++;
        }
    }
}
