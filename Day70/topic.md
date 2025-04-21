## LIS (Longest Increasing Subsequence)

The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence in a sequence such that all elements of the subsequence are sorted in increasing order.

### Example

Given the array: `[10, 9, 2, 5, 3, 7, 101, 18]`

The LIS is `[2, 3, 7, 101]`, so the length is `4`.

### Approaches

1. **Dynamic Programming (O(n²))**  
    Use a DP array where `dp[i]` represents the length of the LIS ending at index `i`.


