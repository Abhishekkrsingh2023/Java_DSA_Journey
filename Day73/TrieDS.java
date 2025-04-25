package Day73;

import java.util.Arrays;

public class TrieDS {
    // Trie Node
    static class Node {
        Node[] children = new Node[26]; // 26 letters in the English alphabet
        boolean eow; // true if the node is the end of a word

        public Node() {
            Arrays.fill(children, null);
            eow = false;
        }
    }

    // root node
    static Node root = new Node();

    // Insert a word into the Trie
    public static void Insert(String word) {
        Node curr = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); // Get the current character
            int idx = ch - 'a'; // Calculate the index (0-25) for the character
            if (curr.children[idx] == null) // If the child node doesn't exist, create it
                curr.children[idx] = new Node();
            curr = curr.children[idx]; // Move to the child node
        }
        curr.eow = true; // Mark the end of the word
    }

    public static boolean Search(String word) {
        Node curr = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i); // Get the current character
            int idx = ch - 'a'; // Calculate the index (0-25) for the character
            if (curr.children[idx] == null) // If the child node doesn't exist, return false
                return false;
            curr = curr.children[idx]; // Move to the child node
        }
        return curr.eow; // Return true if we reached the end of a word
    }

    // Check if the Trie is empty
    public static boolean isEmpty() {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) // If any child node is not null, return false
                return false;
        }
        return true; // All child nodes are null, return true
    }

 

  

    public static void main(String[] args) {
        String words[] = { "hello", "world", "hi", "there" };
        // Insert words into the Trie
        for (String word : words) {
            Insert(word);
        }
        // Search for words in the Trie
        String searchWords[] = { "hello", "world", "hi", "there", "java" };
        for (String word : searchWords) {
            System.out.println(word + " : " + Search(word));
        }
    }
}
