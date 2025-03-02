# Traversal Techniques in Binary Tree

Traversal in a binary tree refers to the process of visiting each node in a specific order. There are several common traversal techniques:

## 1. In-Order Traversal
In in-order traversal, nodes are recursively visited in the following order:
1. Visit the left subtree
2. Visit the root node
3. Visit the right subtree

### Example
For a binary tree:
```
    1
   / \
  2   3
 / \
4   5
```
The in-order traversal would be: `4, 2, 5, 1, 3`

## 2. Pre-Order Traversal
In pre-order traversal, nodes are recursively visited in the following order:
1. Visit the root node
2. Visit the left subtree
3. Visit the right subtree

### Example
For the same binary tree:
```
    1
   / \
  2   3
 / \
4   5
```
The pre-order traversal would be: `1, 2, 4, 5, 3`

## 3. Post-Order Traversal
In post-order traversal, nodes are recursively visited in the following order:
1. Visit the left subtree
2. Visit the right subtree
3. Visit the root node

### Example
For the same binary tree:
```
    1
   / \
  2   3
 / \
4   5
```
The post-order traversal would be: `4, 5, 2, 3, 1`

## 4. Level-Order Traversal
In level-order traversal, nodes are visited level by level from left to right. This is also known as breadth-first traversal.

### Example
For the same binary tree:
```
    1
   / \
  2   3
 / \
4   5
```
The level-order traversal would be: `1, 2, 3, 4, 5`

## Conclusion
Traversal techniques are fundamental for various operations on binary trees, such as searching, inserting, and deleting nodes. Understanding these techniques is crucial for efficient manipulation and utilization of binary trees.
