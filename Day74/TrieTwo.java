// package Day74;

import java.util.Arrays;

class Node {
    Node[] children = new Node[26]; // 26 letters in the English alphabet
    int cL;
    int cW;

    // Constructor
    public Node() {
        Arrays.fill(children, null); // Initialize all child nodes to null
        cL = 0; // Initialize character count to 0
        cW = 0; // Initialize word count to 0
    }

    // Contains function
    public boolean contains(char ch) {
        return children[ch - 'a'] != null; // Check if the child node exists for the character
    }

    // Get function
    public Node get(char ch) {
        return children[ch - 'a']; // Get the child node for the character
    }

    // Put function
    public void put(char ch, Node node) {
        children[ch - 'a'] = node; // Set the child node for the character
    }
}

public class TrieTwo {
    public Node root; // Root node of the Trie
    // Constructor

    public TrieTwo() {
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.contains(ch))
                curr.put(ch, new Node());
            curr = curr.get(ch);
            curr.cL++; // Increment character count
        }
        curr.cW++; // Increment word count
    }

    // count the word
    public int countWords(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.contains(ch))
                return 0;
            curr = curr.get(ch);
        }
        return curr.cW; // Return the word count
    }

    // countPrefix
    public int countPrefix(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!curr.contains(ch))
                return 0;
            curr = curr.get(ch);
        }
        return curr.cL; // Return the character count
    }

    public static void main(String[] args) {
        TrieTwo trie = new TrieTwo();
        String[] words = {
                "hello", "java", "helicopter", "javac", "cart",
                "hello", "heap", "word", "world", "car"
        };
        // Insert words
        for (String word : words) {
            trie.insert(word);
        }

        // Count words
        for (String word : words) {
            System.out.println("Count of " + word + " : " + trie.countWords(word)); // Count and print result
        }
        System.out.println();
        // count prefix
        String[] prefixs = { "he", "jav", "car", "wor" };
        for (String prefix : prefixs) {
            System.out.println("Count of prefix " + prefix + " : " + trie.countPrefix(prefix));
        }
    }
}
