// package Day75;

class Node {
    Node[] children;
    boolean isEnd;


    public Node() {
        children = new Node[26];
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
}
public class distinctStrings {
    // construct a trie
    private Node root;
    public distinctStrings() {
        root = new Node();
    }
    // insert
    public int getCount(String word) {
        int count = 0;
        for(int i=0;i<word.length()-1;i++){
            Node node = root;
            for(int j=i;j<word.length();j++){
                char ch = word.charAt(j);
                if(!node.containsKey(ch)){
                    node.put(ch,new Node());
                    count++;
                }
                node = node.get(ch);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        distinctStrings ds = new distinctStrings();
        String word = "ababc";
        int count = ds.getCount(word);
        System.out.println("Number of distinct substrings: " + count);
    }
}
