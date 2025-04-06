import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class StronglyConnComp {
    static class DirectedGraph {
        private int V; // Number of vertices
        private ArrayList<Integer>[] adjList;

        // Constructor
        public DirectedGraph(int vertices) {
            this.V = vertices;
            adjList = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new ArrayList<>();
            }
        }

        // Method to add a directed edge from u to v
        public void addEdge(int u, int v) {
            adjList[u].add(v);
        }

        // Method to return the adjacency list
        public ArrayList<Integer>[] getAdjList() {
            return adjList;
        }
    }
    // gets the dfs topo sort
    private static void topoSort(int node,ArrayList<Integer>[]graph,boolean[] vis,Stack<Integer> s) {
        vis[node] = true;
        for(int nbr:graph[node]) {
            if(!vis[nbr])
                topoSort(nbr,graph,vis,s);
        }
        s.push(node);
    }
    // dfs
    private static void dfs(int node,ArrayList<Integer>[]graph,boolean[]vis,ArrayList<Integer>ans) {
        vis[node] = true;
        ans.add(node);
        // neighbors
        for(int nbr:graph[node]) {
            if(!vis[nbr]) {
                dfs(nbr,graph,vis,ans);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> kosarajusAlgo(ArrayList<Integer>[]graph,int V) {
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer>[]transpose = new ArrayList[V];
        for(int i=0;i<V;i++)
            transpose[i] = new ArrayList<>();
        // step 1
        for(int i=0;i<V;i++){
            if(!vis[i])
                topoSort(i,graph,vis,s);
        }
        Arrays.fill(vis,false);
        // step 2
        for(int i=0;i<V;i++)
            for(int nbr:graph[i])
                transpose[nbr].add(i);
        // set of SCC
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        // step3
        while(!s.isEmpty()) {
            int curr = s.pop();
            if(!vis[curr]) {
                ArrayList<Integer> ans = new ArrayList<>();
                dfs(curr,transpose,vis,ans);
                set.add(ans);
            }
        }
        return set;
    }
    public static void main(String[] args) {
        int V = 9;
        DirectedGraph g = new DirectedGraph(V);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 8);
        g.addEdge(8, 7);
        g.addEdge(7, 6);
        g.addEdge(6, 5);


        // gets the graph
        ArrayList<Integer>[]graph = g.getAdjList();
        ArrayList<ArrayList<Integer>> set = kosarajusAlgo(graph,V);
        // the answer
        for(ArrayList<Integer> scc:set)
            System.out.println(scc);
    }
}
