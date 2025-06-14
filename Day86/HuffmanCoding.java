import java.util.PriorityQueue;

class HuffmanCoding {
    static class Node implements Comparable<Node> {
        int freq;
        char chr;
        Node left, right;

        Node(int freq, char chr) {
            this.freq = freq;
            this.chr = chr;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.freq - other.freq; // Compare based on frequency
        }
    }

    public static Node buildHuffmanTree(char[] input, int[] frequencies) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        // Step 1: Create a leaf node for each character and add it to the priority queue
        for (int i = 0; i < input.length; i++) {
            minHeap.add(new Node(frequencies[i], input[i]));
        }

        // Step 2: Build the Huffman tree
        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();
            Node parent = new Node(left.freq + right.freq, '$'); // '$' indicates an internal node
            parent.left = left;
            parent.right = right;
            minHeap.add(parent);
        }

        // The last node is the root of the Huffman tree
        return minHeap.poll();
    }
    // Example usage
    public static void printHuffmanTree(Node root, String code) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) { // If it's a leaf node
            System.out.println(root.chr + ": " + code);
        }
        printHuffmanTree(root.left, code + "0");
        printHuffmanTree(root.right, code + "1");
    }
    public static void main(String[] args) {
        char[] input = {'a', 'b', 'c', 'd', 'e'};
        int[] frequencies = {5, 9, 12, 13, 16};
        Node root = buildHuffmanTree(input, frequencies);
        printHuffmanTree(root, "");
    }
}