// package Day35;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBST {
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

    // Inorder traversals sorts the Binary Search tree
    static void inOrder(Node root, ArrayList<Integer> ans) {
        if (root == null)
            return;
        inOrder(root.left, ans);
        ans.add(root.data);
        inOrder(root.right, ans);
    }

    // ckecks whether a given tree is BST or not
    static boolean isBst(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i) <= ans.get(i - 1))
                return false;
        }
        return true;
    }

    // inorder traversal
    static void inOrderTraversal(Node root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Optimized Check function
    static int prev = Integer.MIN_VALUE;
    // using a previous value to store the previous inorder element
    static boolean isBstOptmized(Node root) {
        if (root == null)
            return true;
        boolean leftAns = isBstOptmized(root.left);
        if (leftAns == false)
            return false;
        if (root.data <= prev)
            return false;
        prev = root.data;
        return isBstOptmized(root.right);
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 20, -1, -1, 15, 25, 12 };
        Node root = buildTree(nodes);
        inOrderTraversal(root);
        System.out.println();
        System.out.println(isBst(root) + "-> Uses Auxilary space");
        System.out.println(isBstOptmized(root)+"-> No extra Spaced used");
    }
}
