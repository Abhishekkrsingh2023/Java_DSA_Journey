# Floyd-Warshall Algorithm

The Floyd-Warshall Algorithm is a **dynamic programming** approach used to find the shortest paths between all pairs of vertices in a **weighted directed graph**. It works with negative edge weights but not with negative cycles.

## Algorithm Steps
1. Initialize the distance matrix **D**, where:
    - \( D[i][j] \) represents the shortest distance from vertex **i** to vertex **j**.
    - \( D[i][j] \) is the edge weight if an edge exists, otherwise **∞**.
    - \( D[i][i] = 0 \) for all vertices **i**.
2. Update \( D[i][j] \) using each vertex \( k \) as an intermediate:

   **D[i][j] = min(D[i][j], D[i][k] + D[k][j])**

   where:
    - \( i, j, k \) are vertex indices.
    - \( D[i][j] \) is the current shortest path from \(**i** **->** **j**\).
    - \( D[i][k] + D[k][j] \) represents the path going through vertex **k**.
3. Repeat for all pairs of vertices.

## Complexity
- **n** is the number of vertices in the graph.
- **Time Complexity:** \( O(n^3) \)
- **Space Complexity:** \( O(n^2) \)

## Applications
- Network Routing Optimization
- Graph and Social Network Analysis
- Game Pathfinding

**Note:** A negative cycle exists if \( D[i][i] < 0 \) for any vertex \( i \).

