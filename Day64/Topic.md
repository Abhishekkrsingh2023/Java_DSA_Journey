
The Cut Into Segments problem is a classic dynamic programming problem that involves finding the maximum number of segments that can be obtained by cutting a rod (or a line) of given length.

## Problem Description
- Given a rod of length N
- Given three possible cutting lengths: x, y, and z
- Find maximum number of segments possible
- Each cut must be of length x, y, or z only

## Key Points
1. **State Definition**: dp[i] = maximum segments possible for length i
2. **Base Case**: dp[0] = 0
3. **Recurrence Relation**:
    ```
    dp[i] = max(
         1 + dp[i-x] if i-x >= 0,
         1 + dp[i-y] if i-y >= 0,
         1 + dp[i-z] if i-z >= 0
    )
    ```

## Approach
1. Use bottom-up dynamic programming
2. Initialize dp array with negative infinity
3. Set dp[0] = 0
4. For each length, try all possible cuts
5. Return dp[N] if valid, else -1

## Time Complexity
- O(N), where N is the length of the rod
- Space Complexity: O(N)