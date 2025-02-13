# Sorting Algorithms

Sorting is a fundamental operation, used to arrange data in a specific order (ascending or descending). Three basic sorting algorithms—Bubble Sort, Selection Sort, and Insertion Sort.

## 1. `Bubble Sort`
Bubble Sort is a simple comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The process is repeated until the list is sorted.

### Working Principle:
1. Compare adjacent elements and swap them if necessary.
2. Move to the next pair and repeat the process.
3. After each full pass, the largest element moves to its correct position.
4. Repeat the process for the remaining elements until no swaps are needed.

### Characteristics:
- **Time Complexity:** O(n²) in the worst and average cases, O(n) in the best case (already sorted list).
- **Space Complexity:** O(1) (in-place sorting algorithm).
- **Stable:** Yes (does not change the relative order of equal elements).
- **Usage:** Used in cases where simplicity is preferred over efficiency.

## 2. `Selection Sort`
Selection Sort is a comparison-based algorithm that divides the list into a sorted and an unsorted region. It repeatedly selects the smallest element from the unsorted portion and swaps it with the first element of the unsorted region.

### Working Principle:
1. Find the smallest element in the unsorted section.
2. Swap it with the first element of the unsorted section.
3. Move the boundary of the sorted section one step to the right.
4. Repeat until all elements are sorted.

### Characteristics:
- **Time Complexity:** O(n²) in all cases.
- **Space Complexity:** O(1) (in-place sorting algorithm).
- **Stable:** No (swaps may change the relative order of equal elements).
- **Usage:** Used when memory space is a constraint and stability is not required.

## 3. `Insertion Sort`
Insertion Sort builds the sorted array one element at a time by taking elements from the unsorted part and inserting them into their correct position in the sorted part.

### Working Principle:
1. Start with the second element and compare it with the previous elements.
2. Shift larger elements one position to the right.
3. Insert the current element into its correct position.
4. Repeat the process for all remaining elements.

### Characteristics:
- **Time Complexity:** O(n²) in the worst and average cases, O(n) in the best case.
- **Space Complexity:** O(1) (in-place sorting algorithm).
- **Stable:** Yes (preserves the order of equal elements).
- **Usage:** Efficient for small datasets or nearly sorted data.

