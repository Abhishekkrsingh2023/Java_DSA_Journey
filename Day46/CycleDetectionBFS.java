import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {
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

        // cycle detection using BFS (Kahn's algorithm)
        boolean detectCycleBFS() {
            int[] inDegree = new int[vertex];
            
            // Calculate in-degree for each vertex
            for(int i = 0; i < vertex; i++) {
                for(int nbr : graph[i]) {
                    inDegree[nbr]++;
                }
            }
            
            // Add vertices with 0 in-degree to queue
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < vertex; i++) {
                if(inDegree[i] == 0) {
                    q.add(i);
                }
            }
            
            int count = 0;
            
            // Process vertices
            while(!q.isEmpty()) {
                int curr = q.poll();
                count++;
                
                // Reduce in-degree of neighbors
                for(int nbr : graph[curr]) {
                    inDegree[nbr]--;
                    if(inDegree[nbr] == 0) {
                        q.add(nbr);
                    }
                }
            }
            
            // If count is less than total vertices, cycle exists
            return count != vertex;
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
        //cycle detection
        System.out.println("Cycle detection using BFS: " + g.detectCycleBFS());
    }
}
