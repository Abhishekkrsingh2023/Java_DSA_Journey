import java.util.*;

public class DijkshtraAlgorithm {
    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Graph class to represent an adjacency list
    static class Graph {
        private final int V; // Number of vertices
        ArrayList<ArrayList<Edge>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Initialize each adjacency list
            }
        }

        // Function to add an edge to the graph
        public void addEdge(int source, int destination, int weight) {
            adj.get(source).add(new Edge(destination, weight));
            adj.get(destination).add(new Edge(source, weight)); // Since it's undirected
        }

        public int[] DijkshtraAlgo(int src) {
            // defining the comparison
            PriorityQueue<Edge> p = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            ArrayList<Integer> ans = new ArrayList<>(5);
            boolean[] explored = new boolean[V]; // initially false
            dist[src] = 0;
            p.add(new Edge(src, 0));
            // exploring the neighbours
            while (!p.isEmpty()) {
                Edge e = p.remove(); // removes the node with min weight
                int node = e.destination; // node to explore
                if (explored[node]) continue; // go back to whileLoop
                // exploring the neighbours
                explored[node] = true;
                for (int i = 0; i < adj.get(node).size(); i++) {
                    Edge edge = adj.get(node).get(i);
                    int nbr = edge.destination;
                    int w = edge.weight;
                    // update if current distance greater the new distance
                    if (dist[nbr] > dist[node] + w) {
                        dist[nbr] = dist[node] + w;
                        p.add(new Edge(nbr, dist[nbr]));
                    }
                }
            }
            return dist;
        }
        // Brute force approach
        public int[] BruteDijkstra(int src) {
            int[] dist = new int[V];
            boolean[] explored = new boolean[V];
            // initially distance is infinity
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[src] = 0; // src -> src
            int n = V;
            while(n-- > 0) {
                int node = -1; // initially no node is selected
                int value = Integer.MAX_VALUE;
                // finding the list distance of Unexplored node
                for(int i=0;i<V;i++) {
                    if(!explored[i] && value > dist[i]) {
                        node = i;
                        value = dist[i];
                    }
                }
                // node is found
                // exploring the neighbors
                if(explored[node]) continue;
                explored[node] = true;
                for(int i=0;i<adj.get(node).size();i++) {
                    Edge e = adj.get(node).get(i);
                    int nbr = e.destination;
                    int w = e.weight;

                    if(dist[nbr] > dist[node]+w) {
                        dist[nbr] = dist[node]+w;
                    }
                }

            }
            return dist;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 5, 6);
        graph.addEdge(2, 4, 3);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 1);
        graph.addEdge(4, 5, 2);

        int[] dist = graph.DijkshtraAlgo(0);
        for (int ele : dist) {
            System.out.print(ele + " ");
        }
        int[] dist2 = graph.BruteDijkstra(0);
        System.out.println();
        for (int ele : dist2) {
            System.out.print(ele + " ");
        }
    }
}
