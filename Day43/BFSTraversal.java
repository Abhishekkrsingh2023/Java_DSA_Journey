// package Day43;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    // returns arraylist for the bfs traversal
    static ArrayList<Integer> bfs(ArrayList<Integer>[] graph, int start, int vertex) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[vertex];
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
        return ans;
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
        ArrayList<Integer> ans = bfs(graph, 0, 5);
        System.out.println(ans);
    }
}
