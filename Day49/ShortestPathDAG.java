import java.util.*;

class ShortestPathDAG {
    private final int V;  // Number of vertices
    private final List<List<Edge>> adj;  // Adjacency list

    // Edge class representing (destination, weight)
    static class Edge {
        int dest, weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public ShortestPathDAG(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add directed edge with weight
    public void addEdge(int src, int dest, int weight) {
        adj.get(src).add(new Edge(dest, weight));
    }

    // Get adjacency list representation
    public List<List<Edge>> getAdjacencyList() {
        return adj;
    }

    // Print Graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Node " + i + " -> ");
            for (Edge edge : adj.get(i)) {
                System.out.print("(" + edge.dest + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // gets the list of list for the graph
    public List<List<Edge>> getAdj() {
        return adj;
    }

    // dfs for the topological Sort
    private static void dfs(List<List<Edge>> graph, int node, Stack<Integer> ans, boolean[] visited) {
        visited[node] = true;
        // Neighbours
        for (int i = 0; i < graph.get(node).size(); i++) {
            int nbr = graph.get(node).get(i).dest;
            if (!visited[nbr]) {
                dfs(graph, nbr, ans, visited);
            }
        }
        ans.push(node);
    }

    // topological sort
    public static Stack<Integer> getTopoSort(List<List<Edge>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> ans = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i])
                dfs(graph, i, ans, visited);
        }
        return ans;
    }

    public static int[] getDistance(List<List<Edge>> graph, int src) {
        Stack<Integer> s = getTopoSort(graph);
        int[] dist = new int[graph.size()];
        Arrays.fill(dist,Integer.MAX_VALUE);
        // Initial node
        dist[src] = 0;
        while(!s.isEmpty()) {
            int node = s.pop();
            // neighbours
            for(int i=0;i<graph.get(node).size();i++) {
                int nbr = graph.get(node).get(i).dest;
                int w = graph.get(node).get(i).weight;
                dist[nbr] = Math.min(dist[nbr], w + dist[node]);
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        ShortestPathDAG graph = new ShortestPathDAG(7);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 10);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 1);

        List<List<Edge>> g = graph.getAdj();
        int[] dist = getDistance(g, 0);

        for(int val:dist) {
            System.out.print(val+" ");
        }
    }
}
