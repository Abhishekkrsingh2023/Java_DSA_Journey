// package Day44;

import java.util.ArrayList;

public class DetectCycleDfs {
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
    public static boolean isCyclic(ArrayList<Integer>[] graph,int node,int parent,boolean[] visited) {
        visited[node] = true;

        for(int i=0;i<graph[node].size();i++) {
            int neighbor = graph[node].get(i); // Neighbour
            if(parent != neighbor) { // if parent and neighbour are not equal
                if(visited[neighbor]) {
                    return true;
                }
                if(isCyclic(graph, neighbor, node, visited)) {
                    return true;
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
        int parent = -1,node = 0;
        boolean[] visited = new boolean[5];
        boolean ans = false;
        // creates the graph
        getGraph(graph);
        for(int i=0;i<5;i++) {
            if(!visited[i]) {
                ans = isCyclic(graph, i, parent, visited);
                if(ans) break; // answer found
            }
        }
        System.out.println(ans);
    }
}
