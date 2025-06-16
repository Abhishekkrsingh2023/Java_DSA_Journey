// package Day87;

// Node class for AVL Tree
class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1; // Height starts from 1, not 0
        left = right = null;
    }

}

public class AvlTree {
    public static Node insert(Node root, int data) {
        // Normal Insertion
        if (root == null)
            return new Node(data);
        if (data > root.data)
            root.right = insert(root.right, data); // BUG FIX: Assign return value
        else if (data < root.data)
            root.left = insert(root.left, data); // BUG FIX: Assign return value
        else
            return root;

        // updating the height
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // Balancing factor
        int bf = balanceFactor(root);

        // LL unbalanced
        if (bf > 1 && data < root.left.data) {
            return rightRotate(root);
        }
        // RR unbalanced
        else if (bf < -1 && data > root.right.data) {
            return leftRotate(root);
        }
        // LR unbalanced
        else if (bf > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // RL unbalanced
        else if (bf < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        // balanced
        else
            return root;

    } // Left Roatation

    private static Node leftRotate(Node root) {
        Node child = root.right;
        Node rightChild = child.left;
        child.left = root;
        root.right = rightChild;

        //Update heights in correct order
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;

    } // Right Roatation

    private static Node rightRotate(Node root) {
        Node child = root.left;
        Node leftChild = child.right;
        child.right = root;
        root.left = leftChild;

        // BUG FIX: Update heights in correct order
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        child.height = 1 + Math.max(getHeight(child.left), getHeight(child.right));
        return child;

    }

    // Balancing factor
    private static int balanceFactor(Node root) {
        return getHeight(root.left) - getHeight(root.right);
    } // gets the height of the current node

    private static int getHeight(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    // Inorder traversal to print the AVL Tree
    public static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] data = { 10, 20, 30, 50, 70, 5, 100, 95 };

        Node root = null; // Root for the AVL Tree
        for (int i = 0; i < data.length; i++) {
            root = insert(root, data[i]);
        }
        inorder(root);
        System.out.println();
    }
}
