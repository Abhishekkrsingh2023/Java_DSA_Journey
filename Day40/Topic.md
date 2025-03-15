# Priority Queue and its Types

## Introduction
A priority queue is a special type of queue where elements are served based on their priority rather than their arrival time.Internally it is implemented using Heap property.

## Types of Priority Queues
1. **Min Priority Queue**
    - Elements with smaller values have higher priority
    - The smallest element is always at the front

2. **Max Priority Queue**
    - Elements with larger values have higher priority
    - The largest element is always at the front

## Implementation Approaches
- Binary Heap (most common)
- Binary Search Tree
- Array/Linked List

## Time Complexity
| Operation | Time Complexity |
|-----------|----------------|
| Insert    | O(log n)      |
| Delete    | O(log n)      |
| Peek      | O(1)          |
