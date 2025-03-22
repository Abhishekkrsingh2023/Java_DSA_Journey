import GraphConstruct.Graph; // user defined graph

import java.util.List;

public class BipartiteGraphDFS {
    public static boolean isBipartite(List<Integer>graph[],int node,int color[]) {
        // neighbours
        for(int i=0;i<graph[node].size();i++) {
            int nbr = graph[node].get(i);
            if(color[nbr] == -1) {
                color[nbr] = (color[node]+1)%2;
                if(!isBipartite(graph,nbr,color))
                    return false;
            }
            else {
                if(color[nbr]== color[node]) return false;
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
//        gp.addEdge(5,8);
        gp.addEdge(5,6);
//        gp.addEdge(5,7);
        gp.addEdge(7,2);
        // gets the list representation of the graph
        List<Integer> graph []= gp.getAdjacencyList();
        int color[] = new int[vertex];
        for (int i=0;i<vertex;i++) {
            color[i] = -1; // -1 means no color
        }
        boolean ans = true;
        color[0] = 0; // starting with 0;
        for(int i=0;i<vertex;i++) {
            if(color[i] == -1) {
                ans = isBipartite(graph,i,color);
                if(!ans) break;
            }
        }
        System.out.println(ans);

    }

}
