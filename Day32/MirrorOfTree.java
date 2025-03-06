import java.util.LinkedList;
import java.util.Queue;

public class MirrorOfTree {
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
    // converts the tree to its mirror image
    static void getMirror(Node root) {
        if(root == null) return;
        // left -> right and right -> left (swapped);
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // for left and right subtree
        getMirror(root.left);
        getMirror(root.right);
    }
    static void preOrder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,3,4,5,7,8};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        /*
                    1
                  /   \
                 2     3
               /  \   /  \
              4    5 7    8    
        */
        preOrder(root); // checking using preorder traversal
        // getting the mirror of the tree
        getMirror(root);
        System.out.println();
        preOrder(root);
    }
}
