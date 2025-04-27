# Count Word and Count Prefix in a Trie

A **Trie** (pronounced "try") is a tree-like data structure used to efficiently store and retrieve strings, especially useful for dictionary and prefix-based searches.

## Counting Words in a Trie

- Each node in a Trie can store a `wordCount` value.
- `wordCount` is incremented when a word ends at that node.
- This allows you to count how many times a word has been inserted.

## Counting Prefixes in a Trie

- Each node can also store a `prefixCount` value.
- `prefixCount` is incremented for every node visited during insertion.
- This helps in quickly finding how many words share a given prefix.

## Applications

- Autocomplete systems
- Spell checkers
- Word frequency analysis

## Summary Table

| Operation        | Description                                 |
|------------------|---------------------------------------------|
| Count Word       | Number of times a word is inserted          |
| Count Prefix     | Number of words sharing a given prefix      |
