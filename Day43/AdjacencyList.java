// package Day43;
import java.util.ArrayList;

public class AdjacencyList {
    public static void main(String[] args) {
        int vertex = 5; // 0 1 2 3 4
        ArrayList<Integer> graph[] = new ArrayList[vertex];
        for(int i=0;i<vertex;i++) {
            graph[i] = new ArrayList<>(); // initializing each arraylist object
        }
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

        // Printing the adjacency list
        for(int i=0;i<vertex;i++) {
            ArrayList<Integer> list = graph[i];
            System.out.print(i+" -> ");
            for(int nbr:list) {
                System.out.print(nbr+" ");
            }
            System.out.println();
        }
    }
}

