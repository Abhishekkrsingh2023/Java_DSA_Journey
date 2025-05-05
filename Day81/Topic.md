# Segment Tree

A segment tree is a data structure designed for efficient range queries and updates on arrays.

## Key Concepts
- Tree-based data structure
- Supports range queries in O(log n) time
- Allows for efficient updates in O(log n) time
- Uses divide and conquer approach

## Operations
1. Build - O(n)
2. Range Query - O(log n)
3. Update - O(log n)

## Common Applications
- Range sum queries
- Range minimum/maximum queries
- Range GCD queries
- Lazy propagation for range updates

## Implementation Details
- Usually implemented as an array
- Parent node contains aggregate info of children
- Leaf nodes represent original array elements

## Advantages
- Fast query processing
- Flexible for different types of range operations
- Space efficient compared to other range query structures

## Time Complexity
| Operation | Complexity |
|-----------|------------|
| Build     | O(n)      |
| Query     | O(log n)  |
| Update    | O(log n)  |

## Space Complexity
- O(n) where n is the size of input array