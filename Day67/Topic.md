# Count the Subset Sum Problem

The **Count the Subset Sum Problem** is a variation of the classic Subset Sum Problem. Instead of determining whether a subset with a given sum exists, the goal is to **count the number of subsets** whose sum equals a target value.

## Problem Statement

Given an array of positive integers `arr[]` and an integer `sum`, find the number of subsets of `arr[]` whose elements sum up to `sum`.

### Example

```text
Input: arr = [2, 3, 5, 6, 8, 10], sum = 10
Output: 3

Explanation:
Subsets are: [2, 8], [10], [2, 3, 5]
```

## Approach

### 1. Recursive Solution

- For each element, decide to include or exclude it.
- Base cases:
    - If `sum == 0`, count as 1 subset (empty subset).
    - If `n == 0` and `sum != 0`, count as 0.

### 2. Dynamic Programming (DP)

- Use a 2D DP table `dp[n+1][sum+1]` where `dp[i][j]` is the number of subsets from the first `i` elements with sum `j`.
- Recurrence:
    - If `arr[i-1] <= j`:  
        `dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]]`
    - Else:  
        `dp[i][j] = dp[i-1][j]`

### 3. Space Optimization

- Use a 1D DP array since each row depends only on the previous row.

## Time Complexity

- DP approach: **O(n * sum)**
- Space: **O(n * sum)** (can be optimized to O(sum))

## Applications

- Partition problems
- Counting ways to achieve a target sum
- Resource allocation problems
