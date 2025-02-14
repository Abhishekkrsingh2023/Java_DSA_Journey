# **Topic**
## Merge Sort
Merge Sort is a **`divide-and-conquer`** sorting algorithm that splits an array into smaller subarrays, sorts them, and then merges them back together. It's known for its **`stable sorting`** nature and has a time complexity of **`O(n log n)`** in all cases.
---

## **How Merge Sort Works**
1. **Divide**: Recursively split the array into two halves until each subarray has a single element.
2. **Conquer**: Sort the individual elements.
3. **Merge**: Combine the sorted subarrays to form a sorted array.


## **Time Complexity Analysis**
- **Best Case**: **O(n log n)**
- **Worst Case**: **O(n log n)**
- **Average Case**: **O(n log n)**  
Since the array is split into halves **log n** times, and merging takes **O(n)** time at each level.

## **Space Complexity**
- **O(n)** (because it requires additional space for merging)
