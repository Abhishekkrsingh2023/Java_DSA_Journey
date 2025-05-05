package SegTree;

public class SegmentTree {
    private static class Node {
        int startIndex;
        int endIndex;
        int data;
        Node left, right;

        public Node(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    private Node root;
    private int n; // size of array
    // Segment Tree Constructor

    public SegmentTree(int[] arr) {
        if (arr == null)
            root = null;
        n = arr.length;
        root = constructTree(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 10, 6, 13, 0, -5 };
        SegmentTree tree = new SegmentTree(arr);
        System.out.println(tree.query(2, 6));
    }

    // performing the query
    public int query(int start, int end) {
        return query(root, start, end);
    }

    // Constructing the segment tree
    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            // leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node newNode = new Node(start, end);
        int mid = (start + end) >> 1;
        newNode.left = constructTree(arr, start, mid);
        newNode.right = constructTree(arr, mid + 1, end);
        newNode.data = newNode.left.data + newNode.right.data;
        return newNode;
    }

    // Query Function
    private int query(Node root, int start, int end) {
        // base case
        if (root == null)
            return 0;
        // Total overlap
        if (start <= root.startIndex && root.endIndex <= end)
            return root.data;
        // no overlap
        if (root.endIndex < start || root.startIndex > end)
            return 0;
        // partial overlap
        int leftAns = query(root.left, start, end);
        int rightAns = query(root.right, start, end);
        return leftAns + rightAns;
    }

    // Updating element
    public void update(int idx, int element) {
        // idx out of range
        if (idx < root.startIndex || idx > root.endIndex)
            return;
        update(root, idx, element);
    }

    private void update(Node root, int idx, int element) {
        if (root.startIndex == root.endIndex) {
            // Leaf node
            root.data = element;
            return;
        }
        int mid = (root.startIndex + root.endIndex) >> 1;
        if (idx <= mid) {
            update(root.left, idx, element);
        } else {
            update(root.right, idx, element);
        }
        root.data = root.left.data + root.right.data;
    }

}
