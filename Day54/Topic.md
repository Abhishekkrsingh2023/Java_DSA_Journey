# Prim's Algorithm

Prim's Algorithm is a greedy algorithm used to find the **Minimum Spanning Tree (MST)** of a weighted, connected, and undirected graph. It ensures that all vertices are connected with the minimum possible total edge weight.

## Algorithm Steps
1. **Initialize**: Select an arbitrary starting vertex.
2. **Priority Queue**: Use a Min-Heap to store edges, prioritized by weight.
3. **Grow the MST**:
   - Pick the edge with the lowest weight that connects a new vertex.
   - Mark the new vertex as visited.
   - Add its edges to the priority queue if they lead to unvisited vertices.
4. **Repeat** until all vertices are included in the MST.

## Time Complexity
- **O(E log V)** using a **Priority Queue (Min-Heap)**, where `V` is the number of vertices and `E` is the number of edges.

## Applications
- **Network Design** (Computer networks, electrical grids, road systems)
- **Cluster Analysis** in Machine Learning
- **Approximation Algorithms** (for problems like the Traveling Salesman Problem)
- **Image Processing** (e.g., segmentation using graphs)

## Summary
Prim’s Algorithm efficiently finds the **Minimum Spanning Tree** using a greedy approach. By leveraging a priority queue, it ensures that the overall complexity remains **O(E log V)**, making it suitable for large graphs.
