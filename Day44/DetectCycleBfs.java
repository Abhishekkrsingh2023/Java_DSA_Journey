// package Day44;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleBfs {
    // creating the graph
    static void getGraph(ArrayList<Integer>[] graph) {
        // adding the graph connection
        graph[0].add(1);
        graph[0].add(2);

        graph[1].add(0);

        graph[2].add(0);
        graph[2].add(3);
        // graph[2].add(4);

        graph[3].add(2);
        graph[3].add(4);

        // graph[4].add(2);
        graph[4].add(3);
    }

    static class Node {
        int node;
        int parent;

        Node(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }
    // cycle detection using bfs
    public static boolean isCyclic(ArrayList<Integer>[] graph, int node, boolean[] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));
        visited[node] = true;

        while (!q.isEmpty()) {
            Node curr = q.remove(); // current node
            ArrayList<Integer> list = graph[curr.node]; // Neighbour list
            // Neighbours
            for (int nbr : list) {
                if (curr.parent != nbr) {
                    if (visited[nbr]) {
                        return true;
                    }
                    else {
                        q.add(new Node(nbr,curr.node));
                        visited[nbr] = true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }
        int parent = -1, node = 0;
        boolean[] visited = new boolean[5];
        boolean ans = false;
        // creates the graph
        getGraph(graph);
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                ans = isCyclic(graph, i, visited);
                if (ans)
                    break; // answer found
            }
        }
        System.out.println(ans);
    }
}
