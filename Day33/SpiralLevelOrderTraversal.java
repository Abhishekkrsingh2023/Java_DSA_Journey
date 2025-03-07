// package Day33;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralLevelOrderTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Tree class to create trees
    static class BinaryTree {
        int idx;

        // Creating tree in Level Order format
        Node buildTree(int nodes[]) {
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
    }

    // Helper function to print level-order traversal
    public static void levelOrder(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp = q.poll();
                System.out.print(temp.data + " ");
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            System.out.println();
        }
    }

    // prints in spiral order
    static void spiralBfs(Node root) {
        if (root == null)
            return;
        // for the spiral order Stack(LIFO) is used
        Stack<Node> s1 = new Stack<>(); // right -> left order
        Stack<Node> s2 = new Stack<>();// Left -> Right order
        s1.push(root); // starting with right->left(root node)

        while (!s1.isEmpty() || !s2.isEmpty()) { // if both are empty then we stop
            // For right->left we store the elements in right->left order(s2)
            while (!s1.isEmpty()) {
                int n = s1.size();
                for (int i = 0; i < n; i++) {
                    Node temp = s1.pop();
                    System.out.print(temp.data + " ");
                    if (temp.right != null)
                        s2.push(temp.right);
                    if (temp.left != null)
                        s2.push(temp.left);
                }
                System.out.println();
            }
            // For left->right we store the elements in left->right
            while (!s2.isEmpty()) {
                int n = s2.size();
                for (int i = 0; i < n; i++) {
                    Node temp = s2.pop();
                    System.out.print(temp.data + " ");
                    if (temp.left != null)
                        s1.push(temp.left);
                    if (temp.right != null)
                        s1.push(temp.right);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, 4, 5, 6 };
        BinaryTree tree = new BinaryTree();
        // root nodes
        Node root = tree.buildTree(nodes);
        /*
         *      1
         *     / \
         *    2   3
         *   / \ /
         *  4  5 6
         */
        spiralBfs(root);
        
    }
}
