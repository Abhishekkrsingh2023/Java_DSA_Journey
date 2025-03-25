### **Shortest Path in a Directed Acyclic Graph (DAG)**

A Directed Acyclic Graph (DAG) is a directed graph with no cycles. The **shortest path problem** in a DAG can be solved efficiently using **Topological Sorting**. Unlike Dijkstra’s or Bellman-Ford algorithms, this approach works in **O(V + E)** time, making it ideal for DAGs.

---

#### **Algorithm**
1. **Topological Sort:**
    - Order the vertices such that for every directed edge `(u → v)`, `u` appears before `v`.
2. **Relaxation:**
    - Initialize distances: `dist[source] = 0`, others = `∞`.
    - Process vertices in topological order and update the distances for their neighbors.

---

#### **Time Complexity**
- **O(V + E)** (Topological sort + Edge relaxation)