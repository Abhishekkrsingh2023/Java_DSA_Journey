// package Day36;

import java.util.LinkedList;
import java.util.Queue;

public class KthLargestElement {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int idx;

    // Creating tree in Level Order format
    static Node buildTree(int nodes[]) {
        idx = 0;
        if (nodes.length == 0 || nodes[idx] == -1)
            return null;
        Node root = new Node(nodes[idx++]);
        Queue<Node> q = new LinkedList<>();
        q.add(root); // Add root to queue

        while (idx < nodes.length) {
            Node curr = q.remove();

            // Left Node
            if (nodes[idx] != -1) {
                curr.left = new Node(nodes[idx]);
                q.add(curr.left);
            }
            idx++; // Move to next node

            // Right Node
            if (idx < nodes.length && nodes[idx] != -1) {
                curr.right = new Node(nodes[idx]);
                q.add(curr.right);
            }
            idx++; // Move to next node
        }
        return root;
    }

    // inorder traversal
    static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.right);
        System.out.print(root.data + " ");
        inOrderTraversal(root.left);
    }

    // Answer class for reference
    static class Answer {
        int large;
        int count;
    }

    static void inorder(Node root, Answer ans, int k) {
        if (root == null)
            return;
        inorder(root.right, ans, k);
        ans.count++;
        if (ans.count == k)
            ans.large = root.data;

        if (ans.count > k)
            return;
        inorder(root.left, ans, k);
    }

    // kth largest
    static int kthLargest(Node root, int k) {
        if (k <= 0)
            return Integer.MIN_VALUE;
        Answer ans = new Answer();
        inorder(root, ans, k);
        return ans.large;
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 33, 2, 6, 15, -1, -1, -1, -1, -1, 11, 18 };
        Node root = buildTree(nodes);
        inOrderTraversal(root);
        System.out.println("\n\t" + kthLargest(root, 5));
    }
}
