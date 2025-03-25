import java.util.*;
import GraphConstruction.DirectedGraph;

public class KahnsAlgorithm {
    public static List<Integer> getTopoSort(List<Integer>[] graph) {
        int V = graph.length;
        int[] inDegree = new int[V];
        List<Integer> topoSort = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Calculate in-degree of all nodes
        for (int i = 0; i < V; i++) {
            for (int nbr : graph[i]) {
                inDegree[nbr]++;
            }
        }
        // Adding all nodes with in-degree 0 to the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process nodes(neighbours) in BFS manner
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort.add(node);

            // Reduce in-degree of neighbors
            for (int nbr : graph[node]) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    queue.add(nbr);
                }
            }
        }

        // If topoSort size is not equal to V, the graph had a cycle
        if (topoSort.size() != V) {
            System.out.println("Cycle detected! Topological sort not possible.");
            return new ArrayList<>();  // Return empty list if cycle exists
        }

        return topoSort;
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 4);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        List<Integer>[] graph = g.getAdjacencyList();
        List<Integer> topoSort = getTopoSort(graph);

        if (!topoSort.isEmpty()) {
            System.out.println("Topological Sort: " + topoSort);
        }
    }
}
