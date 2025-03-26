# Dijkstra's Algorithm

## Introduction
Dijkstra's Algorithm is a graph search algorithm that finds the shortest path from a single source vertex to all other vertices in a weighted graph with non-negative edge weights. It is widely used in network routing, mapping systems, and various optimization problems.

## Algorithm Explanation
Dijkstra’s Algorithm uses a **greedy** approach and follows these steps:

1. **Initialize:**
    - Assign a tentative distance of 0 to the source node and ∞ (infinity) to all other nodes.
    - Create a priority queue (or a min-heap) to store nodes based on their tentative distances.

2. **Processing Nodes:**
    - Extract the node with the smallest tentative distance from the priority queue.
    - Update the distances of its neighboring nodes if a shorter path is found.
    - Insert or update the neighbors in the priority queue.

3. **Repeat Until All Nodes Are Processed:**
    - Continue extracting the smallest distance node and updating its neighbors until all nodes have been visited.


## Time Complexity
- Using a simple array: **O(V²)** (where V is the number of vertices)
- Using a binary heap: **O((V + E) log V)** (where E is the number of edges)
- Using a Fibonacci heap: **O(E + V log V)** (optimized for dense graphs)

## Applications
- **GPS and Navigation Systems**: Finding the shortest route in maps.
- **Network Routing**: Optimizing data packet transmission.
- **AI and Robotics**: Pathfinding in games and autonomous systems.

## Conclusion
Dijkstra’s Algorithm is a fundamental shortest-path algorithm that efficiently computes the optimal path in graphs with non-negative weights. Understanding its working mechanism is crucial for solving various real-world path optimization problems.

