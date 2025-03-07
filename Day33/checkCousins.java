// package Day33;

import java.util.LinkedList;
import java.util.Queue;

public class checkCousins {
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

    // checks if two nodes share the same parent
    static boolean isParent(Node root, int a, int b) {
        if (root == null)
            return false;
        if (root.left != null && root.right != null) {
            if ((root.left.data == a && root.right.data == b) ||
                    (root.left.data == b && root.right.data == a))
                return true;
        }
        return isParent(root.left, a, b) || isParent(root.right, a, b);
    }

    // checks for cousins
    static boolean areCousins(Node root, int a, int b) {
        if (root == null)
            return false;
        if(root.left==null && root.right== null) return false;
        int l1 = -1, l2 = -1; // initial level of both nodes
        // levelorder traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node temp = q.remove();
                if (temp.data == a)
                    l1 = level;
                if (temp.data == b)
                    l2 = level;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            level++;
            if (l1 != l2)
                return false;
            if (l1 != -1)
                break; // found the level for both the values
        }
        return (l1==l2) && !isParent(root, a, b); // checking if both have same parent
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, 4, 5, 6 };
        BinaryTree tree = new BinaryTree();
        // root nodes
        Node root = tree.buildTree(nodes);
        /*
         * 1
         * / \
         * 2 3
         * / \ /
         * 4 5 6
         */
        int a = 6, b = 5;
        // levelOrder(root);
        System.out.println(areCousins(root, a, b));
    }
}