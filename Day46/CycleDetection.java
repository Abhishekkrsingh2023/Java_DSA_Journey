import java.util.ArrayList;

public class CycleDetection {
    // edge class (src -> dest)
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static class Graph {
        int vertex;
        ArrayList<Integer> graph[];

        Graph(int vertex) {
            this.vertex = vertex;
            graph = new ArrayList[vertex];
            // initializing each ArrayList
            for (int i = 0; i < vertex; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        void add(Edge e) throws Exception {
            if (e.src < vertex && e.dest < vertex)
                graph[e.src].add(e.dest); // src -> dest, dest ,dest ... ans so on
            else
                throw new Exception("Vertex out of range");
        }

        void printGrap() {
            for (int i = 0; i < vertex; i++) {
                ArrayList<Integer> nbr = graph[i];
                for (int n : nbr)
                    System.out.println(i + "-> " + n + " ");
            }
        }

        // detects the cycle
        boolean detectCycle(int node, boolean path[]) {
            path[node] = true;
            // for the neighbours
            for (int i = 0; i < graph[node].size(); i++) {
                int nbr = graph[node].get(i);
                if (path[nbr])
                    return true;
                if (detectCycle(nbr, path))
                    return true;
            }
            path[node] = false;
            return false;
        }

        // Optimized Cycle detection
        boolean optimizedDetect(int node, boolean path[], boolean visited[]) {
            path[node] = true;
            visited[node] = true;

            // neighbours
            for (int i = 0; i < graph[node].size(); i++) {
                int nbr = graph[node].get(i);
                if (path[nbr])
                    return true;
                if (visited[nbr])
                    continue; // already visisted that path with no cycle detetcted
                if (optimizedDetect(nbr, path,visited))
                    return true;
            }
            path[node] = false;
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int vertex = 8;
        Graph g = new Graph(vertex); // 0 1 2 3 4 5 6 7
        g.add(new Edge(0, 1));
        g.add(new Edge(1, 2));
        g.add(new Edge(2, 3));
        g.add(new Edge(2, 4));
        g.add(new Edge(3, 5));
        g.add(new Edge(4, 5));
        g.add(new Edge(4, 6));
        g.add(new Edge(6, 7));
        g.add(new Edge(7, 2)); // forms the cycle
        // path
        boolean path[] = new boolean[vertex];
        // visited
        boolean visited[] = new boolean[vertex];
        System.out.println(g.detectCycle(0, path));
        System.out.println(g.optimizedDetect(0, path, visited));
    }
}
