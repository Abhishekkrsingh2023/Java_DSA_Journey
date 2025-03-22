# Bipartite Graph
A bipartite graph is a graph whose vertices can be divided into two independent sets such that every edge connects vertices from different sets. In other words, vertices can be colored using two colors where no adjacent vertices have the same color.

## Characteristics
- Two disjoint vertex sets
- No edges between vertices in the same set
- Can be verified using graph coloring
- Common in matching problems

## Applications
- Assignment problems
- Scheduling tasks
- Pattern matching
- Social network analysis

## Detection
- Can be detected using BFS or DFS
- If odd-length cycle exists, graph is not bipartite