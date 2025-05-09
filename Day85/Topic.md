# Sliding Window Problems

## 1. Fruit Basket Problem
This problem involves finding the maximum number of fruits that can be collected considering only two types of fruits at a time.


### Approach
- Uses sliding window technique with a HashMap to track fruit frequencies
- Maintains a window with at most 2 types of fruits
- Time Complexity: O(n)
- Space Complexity: O(1) as we store at most 2 elements

---

## 2. Maximum Consecutive Ones (with k flips)
This problem involves finding the longest sequence of 1's we can get by flipping at most k zeros.

### Approach Comparison
1. **Brute Force:**
   - Uses nested loops to check all possible subarrays
   - Time Complexity: O(n²)
   - Space Complexity: O(1)

2. **Optimized:**
   - Uses sliding window technique
   - Maintains count of zeros in current window
   - Time Complexity: O(n)
   - Space Complexity: O(1)