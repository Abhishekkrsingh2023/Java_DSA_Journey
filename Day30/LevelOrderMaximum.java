// package Day30;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderMaximum {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int idx = -1;

    // Builds the Binary tree
    public static Node buildTree(int[] nodes) {
        idx++;
        // base case for null nodes
        if (nodes[idx] == -1)
            return null;
        // Node
        Node newNode = new Node(nodes[idx]);
        // left subtree
        newNode.left = buildTree(nodes);
        // right subtree
        newNode.right = buildTree(nodes);
        return newNode;
    }

    // Finds Max element in each level
    public static ArrayList<Integer> getMaxLevel(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                Node curr = q.remove();
                if(curr.data >max) {
                    max = curr.data;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            ans.add(max);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 2, -1, -1, 7, -1, -1, 15, 12, -1, -1, 20, -10, -1, -1, 3, -1, -1 };

        /*
                           10
                         /   \
                        5     15
                       / \   /  \
                      2   7  12  20
                                /  \
                              -10   3
         */
        Node root = buildTree(nodes); // builds the Binary tree
        System.out.println(getMaxLevel(root)); // getting the max elements level wise
    }
}
