# Trie Data Structure

## Introduction
A **Trie** (pronounced as "try") is a tree-like data structure used to efficiently store and retrieve keys in a dataset of strings. It is commonly used for autocomplete, spell checking, and prefix-based searching.

## Key Features
- Stores strings character by character.
- Each node represents a character of a string.
- Fast prefix lookups.
- Space-efficient for large sets of strings with shared prefixes.

## Basic Operations
- **Insert**: Add a word to the Trie.
- **Search**: Check if a word exists in the Trie.
- **StartsWith**: Check if any word in the Trie starts with a given prefix.

## Trie Node Structure (Java Example)
```java
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // For lowercase English letters
    boolean isEndOfWord = false;
}
```

## Example Usage
```java
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
```

## Applications
- Autocomplete systems
- Spell checkers
- IP routing
- Word games

## Complexity
- **Insert/Search/Prefix Search:** O(L), where L is the length of the word/prefix.

