# Maximum Sum of Non-Adjacent Elements

## Problem Description
Finding the maximum sum of non-adjacent elements is a dynamic programming problem where we need to select elements from an array such that no two selected elements are adjacent, and their sum is maximum.

## Key Concepts
1. **State Definition**: At each index, we have two choices:
    - Include the current element
    - Exclude the current element

2. **Recursive Relation**:
    For any index i:
    ```
    maxSum(i) = max(
         arr[i] + maxSum(i+2),  // include current
         maxSum(i+1)            // exclude current
    )
    ```

## Dynamic Programming Approach
- Use tabulation or memoization
- Store results of subproblems
- Time Complexity: O(n)
- Space Complexity: O(n)

## Example Cases
```
Input: [1, 2, 3, 4]
Output: 6 (selecting 2 and 4)

Input: [5, 1, 2, 6]
Output: 11 (selecting 5 and 6)
```

## Applications
- Resource allocation problems
- Schedule optimization
- Network routing Minimum Sum of Non-Adjacent Elements