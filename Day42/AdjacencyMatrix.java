// package Day42;

import java.util.Scanner;

// Unweighted Adjacency Matrix
public class AdjacencyMatrix {
    static void UndirectedGraph(int[][] graph, int edge, Scanner sc) {
        int src, dest;
        System.out.println("Enter the source to destination connection for " + edge + " edges:");
        for (int i = 0; i < edge; i++) {
            src = sc.nextInt();
            dest = sc.nextInt();
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }
    }

    static void directedGraph(int[][] graph, int edge, Scanner sc) {
        int src, dest;
        System.out.println("Enter the source to destination connection for " + edge + " edges:");
        for (int i = 0; i < edge; i++) {
            src = sc.nextInt();
            dest = sc.nextInt();
            graph[src][dest] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the No. of Vertices: ");
        int vertex = sc.nextInt();

        int[][] graph = new int[vertex][vertex];  // Adjacency Matrix (Undirected)
        int[][] graph2 = new int[vertex][vertex]; // Adjacency Matrix (Directed)

        // Undirected Graph
        UndirectedGraph(graph, 5, sc); // 5 connections (bi-directional)
        System.out.println("\nUndirected Graph:");
        for (var row : graph) {
            for (var ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        // Directed Graph
        directedGraph(graph2, 5, sc); // 5 connections (uni-directional)
        System.out.println("\nDirected Graph:");
        for (var row : graph2) {
            for (var ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
