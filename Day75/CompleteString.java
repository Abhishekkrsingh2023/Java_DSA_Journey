class Node {
    Node[] children = new Node[26];
    boolean isEnd = false;

    public Node() {
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }

    // containsKey
    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    // put
    public void put(char ch, Node node) {
        children[ch - 'a'] = node;
    }

    // get
    public Node get(char ch) {
        return children[ch - 'a'];
    }

    // setEnd
    public void setEnd() {
        isEnd = true;
    }

    // isEnd
    public boolean isEnd() {
        return isEnd;
    }
}

public class CompleteString {
    private Node root;

    public CompleteString() {
        root = new Node();
    }

    // insert
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // search
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    // check complete string
    public boolean checkCompleteString(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
            if (!node.isEnd()) {
                return false;
            }
        }
        return node.isEnd();
    }

    // get the longest complete string
    public String getLongestCompleteString(String[] words) {
        String longest = "";
        for (String word : words) {
            if (checkCompleteString(word)) {
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length()) {
                    longest = longest.compareTo(word) < 0 ? longest : word;
                }
            }
        }
        return longest;
    }

    
    public static void main(String[] args) {
        CompleteString trie = new CompleteString();
        String[] words = { "n", "ni", "nin", "ninj", "ninja", "ninjutsu", "ninjutsu" };
        for (String word : words) {
            trie.insert(word);
        }

        System.out.println("Longest complete string: " + trie.getLongestCompleteString(words));

    }
}