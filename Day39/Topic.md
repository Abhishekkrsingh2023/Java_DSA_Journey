# Heap (Deletion)
## Delete Operation on Heap
The delete operation in a heap involves removing the root element, which is the maximum element in a max-heap or the minimum element in a min-heap. The steps to perform the delete operation are as follows:

1. **Replace the root element**: Replace the root element with the last element in the heap.
2. **Remove the last element**: Remove the last element from the heap.
3. **Heapify**: Restore the heap property by performing the heapify operation starting from the root element.

### Steps in Detail

1. **Replace the Root Element**:
    - Swap the root element with the last element in the heap.

2. **Remove the Last Element**:
    - Remove the last element from the heap, which is now the root element.

3. **Heapify**:
    - Starting from the root, compare the new root with its children.
    - If the heap property is violated, swap the root with the largest child in a max-heap or the smallest child in a min-heap.
    - Repeat the process until the heap property is restored.

