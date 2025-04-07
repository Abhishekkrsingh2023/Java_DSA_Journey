📚 **Topic: Dynamic Programming — Memoization vs Tabulation + Optimized Fibonacci**

Today’s deep dive into Dynamic Programming helped reinforce two core concepts that are game-changers when it comes to solving overlapping subproblems efficiently:

---

## 🚀 **What is Memoization?**
🧠 **Top-Down Approach**  
It involves solving a problem recursively and storing the results of subproblems so that they aren’t computed multiple times.

✔️ We use a **cache (like an array or hashmap)** to remember previous results.  
✔️ Ideal when recursion is already intuitive and easy to implement.

📌 Example: Recursive Fibonacci with memoization stores results as it computes, avoiding exponential time.

---

## ⚙️ **What is Tabulation?**
📈 **Bottom-Up Approach**  
Instead of recursion, we build the solution iteratively from the base cases up.

✔️ No recursion overhead.  
✔️ Usually more space/time efficient than memoization.  
✔️ Great when you can visualize the order of computation.

📌 Example: We compute Fib(0), Fib(1), ... up to Fib(n), storing each value.

---

## 🧮 **Optimized Fibonacci using DP**

Why settle for `O(2^n)` brute force when you can hit `O(n)` with DP, or even **`O(n)` time and `O(1)` space** using optimized variables?



