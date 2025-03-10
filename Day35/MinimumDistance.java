// package Day35;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDistance {
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

    static class Answer {
        int prev;
        int min;

        Answer() {
            prev = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
    }

    static void inorder(Node root, Answer ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        if (ans.prev != Integer.MIN_VALUE) {
            ans.min = Math.min(ans.min, Math.abs(root.data - ans.prev));
        }
        ans.prev = root.data;
        inorder(root.right, ans);
    }

    // gets the minimum distance(absolute)
    static int minDiffInBST(Node root) {
        Answer ans = new Answer();
        inorder(root, ans);
        return ans.min;
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 20, -1, -1, 15, 25, 12 };
        Node root = buildTree(nodes);
        System.out.println(minDiffInBST(root));
    }
}
