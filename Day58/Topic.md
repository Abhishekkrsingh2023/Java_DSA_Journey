🔍 What are SCCs?<br>
A strongly connected component is a subset of nodes in a directed graph where every node is reachable from every other node in the subset — considering the direction of edges.

---
These form the "tight-knit" cycles within a graph, and understanding them is critical in many real-world applications like:
🔹 Deadlock detection in Operating Systems
🔹 Optimizing compilers
🔹 Analyzing web link structures
🔹 Resolving circular dependencies in software systems

⚙️ Kosaraju’s Algorithm – 3 Step Approach

1️⃣ Perform DFS on the original graph and record the finish times<br>
2️⃣ Reverse the graph (transpose it)<br>
3️⃣ Perform DFS again in the order of decreasing finish time<br>

🧩 Each DFS in step 3 gives us one SCC.

🕒 Time Complexity: O(V + E) — super efficient!

💡 Intuition:<br>
Think of SCCs as strongly bonded communities in a graph.
You must be able to reach any node and also return from it.
Kosaraju uses smart tricks: DFS + graph reversal to break the graph into these tightly connected pieces.