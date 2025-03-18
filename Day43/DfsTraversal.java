// package Day43;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DfsTraversal {
    static void dfs(ArrayList<Integer>[] graph, int node, int[] visited) {
        System.out.print(node+" ");
        visited[node] = 1;
        // visiting the neighbours
        for (int i=0;i<graph[node].size();i++) {
            int nbr = graph[node].get(i);
            if (visited[nbr] == 0) {
                dfs(graph, nbr, visited);
            }
        }
    }

    // creating the graph
    static void getGraph(ArrayList<Integer>[] graph) {
        // adding the graph connection
        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);

        graph[2].add(0);
        graph[2].add(3);
        graph[2].add(4);

        graph[3].add(2);
        graph[3].add(4);

        graph[4].add(2);
        graph[4].add(3);
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        // creates the graph
        getGraph(graph);
        ArrayList<Integer> ans = new ArrayList<>();
        int visited[] = new int[5];
        // dfs for each unvisited node

        dfs(graph, 0, visited);

    }
}
