# AVL Tree (Insertion)

## Overview
**AVL Tree** is a **self-balancing Binary Search Tree** where the difference between heights of left and right subtrees cannot be more than **1** for all nodes. Named after inventors **Adelson-Velsky and Landis** (1962).

## Why AVL Trees?
- **Problem with BST:** Can become skewed (like a linked list) leading to O(n) operations
- **Solution:** Keep the tree balanced to ensure O(log n) operations
- **Auto-balancing:** Automatically maintains balance after every insertion/deletion

---

## Key Concepts

### 1. **Balance Factor (BF)**
```
Balance Factor = Height(Left Subtree) - Height(Right Subtree)
```
- **Valid BF:** -1, 0, +1
- **Invalid BF:** < -1 or > +1 (requires rebalancing)

### 2. **Height of Node**
- **Leaf Node:** Height = 1
- **Internal Node:** Height = 1 + max(left_height, right_height)
- **Null Node:** Height = 0

### 3. **Self-Balancing Property**
- After every insertion, check balance factors
- If any node becomes unbalanced, perform rotations
- Restore balance while maintaining BST property

---

## Types of Imbalances

### 1. **Left-Left (LL) Case**
```
    Z (BF = +2)
   /
  Y (BF = +1)
 /
X
```
- **Condition:** BF(Z) > 1 AND new_data < Y.data
- **Solution:** Right Rotation on Z

### 2. **Right-Right (RR) Case**
```
Z (BF = -2)
 \
  Y (BF = -1)
   \
    X
```
- **Condition:** BF(Z) < -1 AND new_data > Y.data
- **Solution:** Left Rotation on Z

### 3. **Left-Right (LR) Case**
```
  Z (BF = +2)
 /
Y (BF = -1)
 \
  X
```
- **Condition:** BF(Z) > 1 AND new_data > Y.data
- **Solution:** Left Rotation on Y, then Right Rotation on Z

### 4. **Right-Left (RL) Case**
```
Z (BF = -2)
 \
  Y (BF = +1)
 /
X
```
- **Condition:** BF(Z) < -1 AND new_data < Y.data
- **Solution:** Right Rotation on Y, then Left Rotation on Z

---

## Rotation Operations

### **Left Rotation**
- **Purpose:** Fix RR imbalance
- **Process:**
  1. Right child becomes new root
  2. Original root becomes left child of new root
  3. Left subtree of right child becomes right subtree of original root
  4. Update heights

### **Right Rotation**
- **Purpose:** Fix LL imbalance
- **Process:**
  1. Left child becomes new root
  2. Original root becomes right child of new root
  3. Right subtree of left child becomes left subtree of original root
  4. Update heights

---

## AVL Insertion Algorithm

### **Step 1: Normal BST Insertion**
- Insert node like in regular BST
- Follow left for smaller values, right for larger values

### **Step 2: Update Heights**
- Backtrack and update height of each ancestor
- Height = 1 + max(left_height, right_height)

### **Step 3: Calculate Balance Factor**
- For each ancestor, calculate BF
- BF = height(left) - height(right)

### **Step 4: Check for Imbalance**
- If |BF| ≤ 1: Node is balanced, continue
- If |BF| > 1: Node is unbalanced, needs rotation

### **Step 5: Perform Rotations**
- **LL Case:** Right rotation
- **RR Case:** Left rotation
- **LR Case:** Left rotation on left child, then right rotation on root
- **RL Case:** Right rotation on right child, then left rotation on root

### **Step 6: Update Heights After Rotation**
- Recalculate heights of affected nodes
- Update in correct order (children first, then parent)

---

## Time & Space Complexity

### **Time Complexity**
- **Insertion:** O(log n)
  - BST insertion: O(log n)
  - Height updates: O(log n)
  - Rotations: O(1) each, at most 2 rotations
- **Search:** O(log n)
- **Height calculation:** O(1) if stored

### **Space Complexity**
- **Storage:** O(n) for n nodes
- **Recursion:** O(log n) for call stack

---

## Key Takeaways
- AVL trees maintain **strict balance** (BF ∈ {-1, 0, 1})
- **Four types of imbalances** require different rotation strategies
- **Height updates** are crucial and must be done in correct order
- **At most 2 rotations** needed for any single insertion
- **O(log n) guaranteed** for all operations due to balanced structure

