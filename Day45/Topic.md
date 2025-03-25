# Topological Sort
Topological sort is a directed graph traversal algorithm that produces a linear ordering of vertices such that for every directed edge (u,v), vertex u comes before v in the ordering. It's only possible for Directed Acyclic Graphs (DAGs).

Key points:
- Cannot contain cycles
- Not unique (multiple valid solutions possible)
- Used for dependency ordering
- Common in build systems and project scheduling

Two main approaches:
1. DFS-based algorithm
2. Kahn's algorithm (using in-degree)

## Kahn's Algorithm
Kahn's algorithm is a method for performing a topological sort on a directed acyclic graph (DAG). It systematically finds an ordering of vertices where for each directed edge u->v, vertex u appears before vertex v.

## Algorithm Steps
1. Calculate in-degree for each vertex
2. Add vertices with 0 in-degree to queue
3. While queue is not empty:
    - Remove vertex from queue
    - Add it to result
    - Reduce in-degree of adjacent vertices
    - If any vertex reaches 0 in-degree, add to queue

## Time Complexity
- Time: O(V + E)
- Space: O(V)
Where V is number of vertices and E is number of edges

## Applications
- Dependency resolution
- Task scheduling
- Build systems
- Course prerequisites