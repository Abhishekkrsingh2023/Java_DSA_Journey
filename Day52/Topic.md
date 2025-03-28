# Bellman-Ford Algorithm

The Bellman-Ford algorithm is a shortest path algorithm that computes the shortest distances from a single source vertex to all other vertices in a weighted graph. Unlike Dijkstra’s algorithm, Bellman-Ford can handle graphs with negative weight edges, making it a more versatile choice for various applications.

## Algorithm Overview
The Bellman-Ford algorithm works by repeatedly relaxing all edges of the graph. This process is repeated exactly (V - 1) times, where V is the number of vertices in the graph. The relaxation step updates the shortest known distance to each vertex by considering all edges and checking if a shorter path exists through an intermediate vertex.

### Steps:
1. **Initialization:**
    - Set the distance to the source vertex as 0.
    - Set the distance to all other vertices as infinity.

2. **Relaxation Process:**
    - For each edge (u, v) with weight w, update the distance to v if `distance[u] + w < distance[v]`.
    - Repeat this process (V - 1) times.

3. **Negative Cycle Detection:**
    - After V - 1 iterations, run one more iteration to check if further relaxation is possible.
    - If a shorter path is still found, the graph contains a negative weight cycle.

## Complexity Analysis
- **Time Complexity:** O(VE), where V is the number of vertices and E is the number of edges.
- **Space Complexity:** O(V), as we need to store distances and predecessors for each vertex.

## Advantages and Disadvantages
### Advantages:
- Can handle graphs with negative weights.
- Detects negative weight cycles.
- Simpler than Dijkstra’s algorithm in certain implementations.

### Disadvantages:
- Slower than Dijkstra’s algorithm for graphs without negative weights.
- Not suitable for large graphs due to its O(VE) complexity.

## Applications
- Finding shortest paths in graphs with negative weights.
- Network routing protocols like RIP (Routing Information Protocol).
- Arbitrage detection in currency exchange networks.
- Constraint satisfaction problems in AI and operations research.
