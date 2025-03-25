import java.util.*;
import GraphConstruction.DirectedGraph;
public class TopologicalSort {
    private static void dfs(List<Integer>[] graph, int node, Stack<Integer> ans, boolean[] visited) {
        visited[node] = true;
        // Neighbours
        for(int i=0;i<graph[node].size();i++) {
            int nbr = graph[node].get(i);
            if(!visited[nbr]) {
                dfs(graph,nbr,ans,visited);
            }
        }
        ans.push(node);
    }

    public static Stack<Integer> getTopoSort(List<Integer>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> ans = new Stack<>();

        for(int i=0;i<graph.length;i++) {
            if(!visited[i])
                dfs(graph,i,ans,visited);
        }
        return ans;
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);

        List<Integer>[] graph = g.getAdjacencyList();
        Stack<Integer> s = getTopoSort(graph);
        while(!s.isEmpty())
            System.out.print(s.pop()+" ");
    }
}
