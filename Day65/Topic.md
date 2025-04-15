## 0/1 Knapsack Theory

The 0/1 Knapsack problem is a classic dynamic programming problem. Given a set of items, each with a weight and a value, and a knapsack with a weight capacity, the goal is to determine the maximum total value of items that can be included in the knapsack without exceeding its capacity. Each item can be included **at most once** (hence "0/1").

### Problem Statement

Given:
- `n` items, each with a weight `w[i]` and value `v[i]`
- Knapsack capacity `W`

Find the maximum value that can be obtained by selecting a subset of the items such that the total weight does not exceed `W`.

### Recurrence Relation

Let `dp[i][j]` be the maximum value for the first `i` items and capacity `j`:

- If we don't include the `i`th item: `dp[i-1][j]`
- If we include the `i`th item (if `w[i-1] <= j`): `v[i-1] + dp[i-1][j-w[i-1]]`

So,
```
dp[i][j] = max(
    dp[i-1][j],
    v[i-1] + dp[i-1][j-w[i-1]]  if w[i-1] <= j
)
```

### Base Cases

- `dp[0][j] = 0` for all `j` (no items)
- `dp[i][0] = 0` for all `i` (zero capacity)

### Time Complexity

- O(nW), where `n` is the number of items and `W` is the knapsack capacity.
