// package Day33;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBalancedTree {
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
    // for our valid answer
    static class Valid{
        boolean val;
        Valid(){
            val = true;
        }
    }
    // Checking for balanced Tree
    static boolean isBalanced(Node root) {
        Valid valid = new Valid();
        height(root,valid);
        return valid.val; // true/false
    }
    static int height(Node root,Valid valid) {
        if(root == null) return 0;
        int leftHeight = height(root.left, valid);
        int rightHeight = height(root.right, valid);
        // checking for valid ans
        if(Math.abs(leftHeight-rightHeight)>1) valid.val = false;

        return 1+ Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        int nodes2[] = { 1, 2, 3, -1,-1,4, 5, 6, 7, 8, 9, 10, 11 };
        BinaryTree tree = new BinaryTree();
        // root nodes
        Node root = tree.buildTree(nodes);
        Node root2 = tree.buildTree(nodes2);

        System.out.println(isBalanced(root)); // true
        System.out.println(isBalanced(root2)); // false

    }
}
