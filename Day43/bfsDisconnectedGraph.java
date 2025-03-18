// package Day43;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsDisconnectedGraph {
    // bfs traversal(modified)
    static void bfs(ArrayList<Integer>[] graph, ArrayList<Integer> ans, int start, int[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);
            // visiting the neighbours
            for (var nbr : graph[curr]) {
                if (visited[nbr] == 0) {
                    q.add(nbr);
                    visited[nbr] = 1;
                }
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

        graph[3].add(4);
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
        // bfs for each unvisited node
        for (int i = 0; i < 5; i++) {
            if (visited[i] == 0) {
                bfs(graph, ans, i, visited);
            }
        }

        System.out.println(ans);
    }
}
