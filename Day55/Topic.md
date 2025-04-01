# Kruskal's Algorithm

## Introduction
Kruskal's Algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) of a connected, undirected graph. It selects the shortest edges first and ensures that no cycles are formed, ultimately connecting all vertices with the minimum possible total edge weight.

## Steps of Kruskal's Algorithm
1. **Sort all edges** in ascending order of their weights.
2. **Initialize an empty set** to store the edges of the MST.
3. **Iterate through the sorted edges** and for each edge:
    - Check if adding the edge creates a cycle using the Union-Find (Disjoint Set) data structure.
    - If no cycle is formed, add the edge to the MST.
4. Repeat step 3 until the MST contains exactly **(V-1) edges**, where V is the number of vertices.

## Time Complexity
- **Sorting edges**: \( O(E \log E) \)
- **Union-Find operations**: \( O(E \log V) \)
- **Overall Complexity**: \( O(E \log E) \) (since \( E \geq V \) in a connected graph)

## Applications
- **Network Design**: Laying out minimum-cost networks (e.g., telecommunication, electrical grids).
- **Clustering in Machine Learning**: Used in hierarchical clustering.
- **Image Segmentation**: Helps in partitioning images based on graph structures.

## Conclusion
Kruskal's Algorithm is an efficient and widely-used method for finding MSTs. By leveraging sorting and the Union-Find data structure, it achieves an optimal solution with a manageable time complexity.

