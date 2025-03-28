import java.util.*;

public class BellmanFord {
    // Edge class to represent a directed, weighted edge
    static class Edge {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class DirectedGraph {
        private int vertices;
        private List<Edge>[] adjList;

        // Constructor to initialize the graph
        public DirectedGraph(int vertices) {
            this.vertices = vertices;
            this.adjList = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new ArrayList<>();
            }
        }
        // Method to add an edge
        public void addEdge(int source, int destination, int weight) {
            adjList[source].add(new Edge(destination, weight));
        }
        // Getter for adjacency list
        public List<Edge>[] getAdjList() {
            return adjList;
        }
    }

    // Bellman-Ford Algorithm
    public static int[] BellFord(List<Edge>[] graph, int v, int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges (V-1) times
        for (int i = 0; i < v - 1; i++) {
            for (int node = 0; node < v; node++) {
                for (Edge nbr : graph[node]) {
                    if (dist[node] != Integer.MAX_VALUE && dist[node] + nbr.weight < dist[nbr.destination]) {
                        dist[nbr.destination] = dist[node] + nbr.weight;
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int node = 0; node < v; node++) {
            for (Edge nbr : graph[node]) {
                if (dist[node] != Integer.MAX_VALUE && dist[node] + nbr.weight < dist[nbr.destination]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return null; // Indicating a negative cycle was detected
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int v = 6;
        DirectedGraph g = new DirectedGraph(v);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 1, 3);
        g.addEdge(1, 2, -2);
        g.addEdge(1, 3, 2);
        g.addEdge(3, 4, -2);
        g.addEdge(3, 5, 8);
        g.addEdge(4, 2, 3);
        g.addEdge(4, 5, -8);
        List<Edge>[] graph = g.getAdjList();

        int[] dist = BellFord(graph, v, 0);

        if (dist != null) {
            System.out.println("Shortest distances from source vertex 0:");
            for (int i = 0; i < v; i++) {
                System.out.println("Vertex " + i + " -> Distance: " + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
            }
        }
    }
}
