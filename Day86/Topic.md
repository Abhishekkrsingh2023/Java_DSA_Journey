# Huffman Coding

## Overview
Huffman Coding is a **lossless data compression algorithm** that assigns variable-length codes to characters based on their frequencies. Characters that appear more frequently get shorter codes, while less frequent characters get longer codes.

## Key Concepts

### 1. **Greedy Algorithm**
- Builds optimal prefix codes by repeatedly combining least frequent nodes
- Uses priority queue (min-heap) to always select minimum frequency nodes

### 2. **Prefix Property**
- No code word is a prefix of another
- Ensures unique decodability
- Example: If 'a' = "01", then no other character can have code starting with "01"

### 3. **Binary Tree Structure**
- Leaf nodes represent characters
- Internal nodes represent combined frequencies
- Left edge = '0', Right edge = '1'

---

## Algorithm Steps

### Step 1: Calculate Frequencies
Count frequency of each character in the input text.

### Step 2: Create Priority Queue
Create a min-heap with all characters as individual nodes.

### Step 3: Build Huffman Tree
```
while (heap has more than 1 node):
    1. Extract two nodes with minimum frequency
    2. Create new internal node with combined frequency
    3. Make extracted nodes as children
    4. Insert new node back to heap
```

### Step 4: Generate Codes
Traverse tree from root to leaves:
- Left child: append '0'
- Right child: append '1'


## Time & Space Complexity

### Time Complexity
- **Building Tree:** O(n log n)
  - n insertions and extractions from priority queue
  - Each operation takes O(log n)
- **Generating Codes:** O(n)
- **Overall:** O(n log n)

### Space Complexity
- **Tree Storage:** O(n) for n characters
- **Priority Queue:** O(n)
- **Overall:** O(n)

---

## Advantages

1. **Optimal Compression:** Produces minimum expected code length
2. **Lossless:** No data is lost during compression
3. **Variable Length:** Efficient for texts with non-uniform character distribution
4. **Prefix Property:** Ensures unique decodability

---

## Disadvantages

1. **Two-Pass Algorithm:** Need to scan text twice (frequency calculation + encoding)
2. **Tree Storage:** Must store/transmit the Huffman tree
3. **Not Suitable:** For texts with uniform character distribution
4. **Static:** Tree built once, doesn't adapt to changing frequencies

---

## Applications

1. **File Compression:** ZIP, GZIP formats
2. **Image Compression:** JPEG uses Huffman coding
3. **Data Transmission:** Efficient data transfer protocols
4. **Text Compression:** Especially for texts with skewed character distribution

---

## Key Points to Remember

1. **Min-Heap Usage:** PriorityQueue in Java is min-heap by default
2. **Greedy Choice:** Always combine two minimum frequency nodes
3. **Prefix Codes:** Ensure no code is prefix of another
4. **Binary Tree:** Left = '0', Right = '1'
5. **Optimal:** Produces minimum expected code length for given frequencies

---

## Practice Problems

1. Build Huffman tree for given frequencies
2. Calculate compression ratio
3. Encode/decode text using Huffman codes
4. Handle edge cases (single character, equal frequencies)
5. Implement Huffman coding with character frequency input