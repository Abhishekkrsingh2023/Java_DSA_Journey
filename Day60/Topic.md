You're right, Abhi — you asked for the **theory**, not the code. My bad for going overboard there.

Here’s a clean **theory-only** version for your `topic.md` file:

---

```markdown
# Climbing Stairs Problem – Dynamic Programming Theory

## Problem Overview

The Climbing Stairs problem is a classic example of Dynamic Programming. Given a staircase with `n` steps, you can climb either **1 step** or **2 steps** at a time. The goal is to determine **how many distinct ways** there are to reach the top.

---

## Key Concept

The number of ways to reach step `n` depends only on how you could have arrived at that step:
- From step `n - 1` (taking 1 step)
- From step `n - 2` (taking 2 steps)

This gives us the recurrence relation:
```
ways(n) = ways(n - 1) + ways(n - 2)
```

This is structurally the same as the **Fibonacci sequence**. Each value depends on the two before it, modeling optimal substructure and overlapping subproblems—two core properties of dynamic programming.

---

## Why It’s a DP Problem

- **Optimal Substructure**: The solution to `ways(n)` relies on solutions to `ways(n-1)` and `ways(n-2)`.
- **Overlapping Subproblems**: The same subproblems are solved multiple times in a naive recursive approach, which is what DP helps avoid.

---

## Applications

- Intro to Dynamic Programming
- Variants can include:
  - Different allowed step sizes (e.g., [1, 3, 5])
  - Costs associated with each step
  - Skipping steps or blocked steps

This problem helps build intuition for solving problems with similar recursive structures using memoization, tabulation, or space optimization.

```

---

Let me know if you want this trimmed down more or if you’re adding sections like **variations** or **real-world analogies**.****