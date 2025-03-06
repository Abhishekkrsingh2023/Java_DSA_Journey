// public package Day32;

import java.util.LinkedList;
import java.util.Queue;

class IdenticalTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Tree class to create trees
    static class BinaryTree {
        int idx;

        BinaryTree() {
            idx = -1;
        }

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

    // checks for identical trees
    static boolean checkIdentical(Node root1, Node root2) {
        // base cases
        if (root1 == null && root2 == null)
            return true;
        // trees are not symmetrical
        if (root1 == null || root2 == null)
            return false;
        // unequal data
        if (root1.data != root2.data)
            return false;
        boolean leftAns = checkIdentical(root1.left, root2.left);
        boolean rightAns = checkIdentical(root1.right, root2.right);
        // ans of left and right subtree
        return leftAns && rightAns;
    }

    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        int nodes1[] = { 1, 2, 3, 4, 5, 7, 8 };
        int nodes2[] = { 1, 2, 3, 4, 5, 9, 8 };
        int nodes3[] = { 1, 2, 3, 4, 5, 7, 8 };

        BinaryTree tree = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        BinaryTree tree3 = new BinaryTree();
        // trees 1,2, and 3
        Node root1 = tree.buildTree(nodes1);
        Node root2 = tree.buildTree(nodes2);
        Node root3 = tree.buildTree(nodes3);
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 7 8
         */
        preOrder(root1);
        System.out.println();
        preOrder(root2);
        System.out.println();
        preOrder(root3);
        System.out.println("\n" + checkIdentical(root1, root2)); // false
        System.out.println(checkIdentical(root1, root3)); // true

    }
}