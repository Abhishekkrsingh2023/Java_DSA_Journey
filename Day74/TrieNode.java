
// package Day74;
import java.util.Arrays;

// Node class for Trie
class Node {
    Node[] children = new Node[26];
    boolean eow;

    public Node() {
        Arrays.fill(children, null);
        eow = false;
    }

    // contains function
    public boolean contains(char ch) {
        return children[ch - 'a'] != null; // Check if the child node exists for the character
    }

    // get function
    public Node get(char ch) {
        return children[ch - 'a']; // Get the child node for the character
    }

    // put function
    public void put(char ch, Node node) {
        children[ch - 'a'] = node; // Set the child node for the character
    }

}

public class TrieNode {
    public Node root;

    public TrieNode() {
        root = new Node(); // Initialize the root node
    }

    // Insert a word into the Trie
    public void Insert(String word) {
        Node curr = root; // Start from the root node
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.contains(ch)) // If the child node doesn't exist, create it
                curr.put(ch, new Node());
            curr = curr.get(ch); // Move to the child node
        }
        curr.eow = true; // Mark the end of the word
    }

    // Search a word in the Trie
    public boolean Search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.contains(ch))
                return false;
            curr = curr.get(ch);
        }
        return curr.eow;
    }

    // startsWith function
    public boolean startsWith(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.contains(ch)) // If the child node doesn't exist, return false
                return false;
            curr = curr.get(ch);
        }
        return true;
    }

    public static void main(String[] args) {
        TrieNode trie = new TrieNode(); // Create a new TrieNode instance
        String words[] = { "hello", "world", "hi", "there" };
        // Insert words into the Trie
        for (String word : words) {
            trie.Insert(word);
        }
        // Search for words in the Trie
        System.out.println(trie.startsWith("word"));
    }
}