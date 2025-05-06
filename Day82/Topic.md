# Fenwick Tree (Binary Indexed Tree)

A Fenwick Tree, also known as a Binary Indexed Tree (BIT), is a data structure that efficiently updates elements and calculates prefix sums in a table of numbers.

## Key Features

- Space Complexity: O(n)
- Time Complexity: O(log n) for both updates and queries
- Perfect for dynamic range sum queries
- More memory efficient than segment trees

## Operations

1. **Update**: Modify a single element
2. **Query**: Calculate prefix sum up to a given index

## How It Works

- Stores partial sums in an array
- Each index represents numbers in binary form
- Uses clever bit manipulation for efficient operations

## Common Applications

- Range sum queries
- Dynamic frequency counting
- Counting inversions
- Implementing various dynamic algorithms

## Implementation Notes

- Array is 1-based indexed
- Parent-child relationship determined by LSB
- Uses bitwise operations for traversal

## Advantages

- Simple implementation
- Memory efficient
- Fast operations
- Perfect for problems involving cumulative operations