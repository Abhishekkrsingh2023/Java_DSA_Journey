// package Day35;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfKElements {
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
        int sum;
        int count;

        Answer(int k) {
            prev = Integer.MIN_VALUE;
            sum = 0;
            count = k;
        }
    }

    // optimized inorder
    static void inorder(Node root, Answer ans) {
        if (root == null)
            return;
        inorder(root.left, ans);
        ans.prev = root.data;
        ans.count--;
        if (ans.count >= 0 ) {
            ans.sum += ans.prev;
        }
        if(ans.count <= 0) return;
        inorder(root.right, ans);
    }

    static int getKsum(Node root, int k) {
        if (root == null)
            return 0;
        Answer ans = new Answer(k);
        inorder(root, ans);
        return ans.sum;
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 20, -1, -1, 15, 25, 12 };
        Node root = buildTree(nodes);
        System.out.println(getKsum(root, 2));
    }

}
