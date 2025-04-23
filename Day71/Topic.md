# Matrix Chain Multiplication

Matrix Chain Multiplication is a classic dynamic programming problem that deals with finding the most efficient way to multiply a given sequence of matrices. The goal is to minimize the total number of scalar multiplications.

## Problem Statement

Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not to perform the multiplications but merely to decide the sequence of the matrix multiplications.

## Example

Given matrices A (10x30), B (30x5), and C (5x60):

- Multiplying (A*B)*C:  
    (10x30) * (30x5) = 10x5 (cost: 10*30*5 = 1500)  
    (10x5) * (5x60) = 10x60 (cost: 10*5*60 = 3000)  
    Total cost = 1500 + 3000 = 4500

- Multiplying A*(B*C):  
    (30x5) * (5x60) = 30x60 (cost: 30*5*60 = 9000)  
    (10x30) * (30x60) = 10x60 (cost: 10*30*60 = 18000)  
    Total cost = 9000 + 18000 = 27000

Optimal order: (A*B)*C with cost 4500.

## Dynamic Programming Approach

Let `p[]` be the array of dimensions such that the ith matrix has dimensions `p[i-1] x p[i]`.

### DP Formula

Let `dp[i][j]` be the minimum number of multiplications needed to multiply matrices from i to j.

```
dp[i][j] = min(dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j])
for all i <= k < j
```

## Key Points

- Matrix multiplication is associative, but the order affects the computation cost.
- Use dynamic programming to avoid redundant calculations.
- The solution has O(n³) time complexity.
