# Longest Common Subsequence (LCS) - Theory

The **Longest Common Subsequence (LCS)** problem is a classic problem in computer science, particularly in the fields of dynamic programming and string processing.

## Definition

Given two sequences (usually strings), the LCS is the longest sequence that appears in both sequences in the same order, but not necessarily contiguously.

- **Subsequence:** A sequence derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
- **Common Subsequence:** A subsequence that is present in both sequences.

## Example

Given:
- Sequence 1: `ABCBDAB`
- Sequence 2: `BDCAB`

The LCS is `BCAB` (length 4).

## Properties

- The LCS is not necessarily unique; there can be multiple subsequences of the same maximum length.
- The LCS problem is different from the Longest Common Substring problem, where the substring must be contiguous.

## Applications

- **File comparison tools** (diff utilities)
- **Bioinformatics** (DNA/protein sequence alignment)
- **Version control systems** (merging changes)
- **Spell checking and correction**

## Approach

The LCS problem is typically solved using dynamic programming, which efficiently computes the length and the actual subsequence by breaking the problem into smaller subproblems and storing their solutions.

## Complexity

- **Time Complexity:** O(m × n), where m and n are the lengths of the two sequences.
- **Space Complexity:** O(m × n), though optimizations can reduce space usage.
