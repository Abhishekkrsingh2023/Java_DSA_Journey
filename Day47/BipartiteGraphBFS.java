import GraphConstruct.Graph; // user defined graph class

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BipartiteGraphBFS {
    // check if the graph is bipartite or not
    static boolean isBipartite(List<Integer>graph[]) {
        Queue<Integer> q = new LinkedList<>();
        // color array
        int color[] = new int[graph.length];
        for (int i=0;i<graph.length;i++) {
            color[i] = -1;
        }
        q.add(0);
        color[0] = 0;

        while(!q.isEmpty()) {
            int n = q.remove();
            // looking for the adjacent neighbous
            for(int i=0;i<graph[n].size();i++) {
                int nbr = graph[n].get(i);
                if(color[nbr] == -1) {
                    color[nbr] = (color[n]+1)%2; // 1->0 and 0->1
                    q.add(nbr);
                }
                else {
                    if(color[nbr] == color[n])
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int vertex = 9;
        // creates a graph with 9 vertices
        Graph gp = new Graph(vertex);
        gp.addEdge(0,1);
        gp.addEdge(1,2);
//        gp.addEdge(2,4);
        gp.addEdge(2,3);
        gp.addEdge(3,4);
        gp.addEdge(4,5);
        gp.addEdge(5,8);
        gp.addEdge(5,6);
        gp.addEdge(6,7);
        gp.addEdge(7,2);
        // gets the list representation of the graph
        List<Integer>graph []= gp.getAdjacencyList();
        System.out.println(isBipartite(graph));
    }
}
