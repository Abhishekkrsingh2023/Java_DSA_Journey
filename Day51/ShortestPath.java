import java.util.*;

public class ShortestPath {
    // Represents an edge in the graph
    static class Edge {
        int destination, weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Graph class using an adjacency list
    static class Graph {
        private final int vertices;
        private final List<List<Edge>> adjList;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Adds an edge to the graph (undirected)
        public void addEdge(int source, int destination, int weight) {
            adjList.get(source).add(new Edge(destination, weight));
            adjList.get(destination).add(new Edge(source, weight));
        }

        // Implements Dijkstra's algorithm to find the shortest distance from src
        public int[] dijkstra(int src) {
            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            boolean[] explored = new boolean[vertices];

            distances[src] = 0;
            minHeap.add(new Edge(src, 0));

            while (!minHeap.isEmpty()) {
                Edge current = minHeap.poll();
                int node = current.destination;
                // for explored node we skip
                if (explored[node]) continue;
                explored[node] = true;
                for (Edge edge : adjList.get(node)) {
                    int neighbor = edge.destination;
                    int weight = edge.weight;

                    if (distances[neighbor] > distances[node] + weight) {
                        distances[neighbor] = distances[node] + weight;
                        minHeap.add(new Edge(neighbor, distances[neighbor]));
                    }
                }
            }
            return distances;
        }

        // Retrieves the shortest path from src to dest
        public List<Integer> getPath(int src, int dest) {
            if (src < 0 || src >= vertices || dest < 0 || dest >= vertices) {
                System.out.println("Invalid vertex");
                return Collections.emptyList();
            }

            List<Integer> parent = new ArrayList<>(Collections.nCopies(vertices, -1));
            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            boolean[] explored = new boolean[vertices];

            distances[src] = 0;
            minHeap.add(new Edge(src, 0));

            while (!minHeap.isEmpty()) {
                Edge current = minHeap.poll();
                int node = current.destination;

                if (explored[node]) continue;
                explored[node] = true;

                for (Edge edge : adjList.get(node)) {
                    int neighbor = edge.destination;
                    int weight = edge.weight;

                    if (distances[neighbor] > distances[node] + weight) {
                        distances[neighbor] = distances[node] + weight;
                        minHeap.add(new Edge(neighbor, distances[neighbor]));
                        parent.set(neighbor, node);
                    }
                }
            }
            // Reconstruct the shortest path
            List<Integer> path = new ArrayList<>();
            for (int current = dest; current != -1; current = parent.get(current)) {
                path.add(current);
            }
            return path.reversed();
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
        int src = 5, dest = 1;
        System.out.println("Shortest path from " + src + " to " + dest + " : " + graph.getPath(src, dest));
    }
}
