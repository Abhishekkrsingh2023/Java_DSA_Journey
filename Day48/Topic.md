# Shortest path in Undirected Graph
In graph theory, finding the shortest path in an undirected graph means determining the path between two vertices that has the minimum total edge weight or number of edges. Key concepts include:

## Key Components
- **Undirected Graph**: A graph where edges have no direction (bidirectional)
- **Path**: A sequence of vertices connected by edges
- **Shortest Path**: Path with minimum total weight/distance between vertices

## Common Algorithms
1. **Breadth-First Search (BFS)**
    - Used for unweighted graphs
    - Finds shortest path in terms of number of edges

2. **Dijkstra's Algorithm**
    - For weighted graphs with non-negative weights
    - Finds shortest path based on edge weights

3. **Bellman-Ford Algorithm**
    - Handles negative edge weights
    - More versatile but slower than Dijkstra's

## Applications
- GPS Navigation
- Network Routing
- Social Networks
- Games (pathfinding)