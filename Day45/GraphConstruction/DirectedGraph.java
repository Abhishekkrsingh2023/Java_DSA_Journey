package GraphConstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a graph using an adjacency list.
 */
public class DirectedGraph {
    private List<Integer>[] adjList;
    private int vertices;

    /**
     * Constructs a graph with the specified number of vertices.
     *
     * @param vertices The number of vertices in the graph.
     */
    @SuppressWarnings("unchecked")
    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    /**
     * Adds a directed edge between two vertices.
     *
     * @param source      The source vertex.
     * @param destination The destination vertex.
     */
    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
    }

    /**
     * Returns the adjacency list representation of the graph.
     *
     * @return A list of adjacency lists representing the graph.
     */
    public List<Integer>[] getAdjacencyList() {
        return adjList;
    }
    /**
     * Displays the adjacency list representation of the graph.
     */
    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " -> " + adjList[i]);
        }
    }
}

