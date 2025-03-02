// package Day28;

public class BinaryTreeTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    static int idx = -1;
    public static Node buildTree(int []nodes) {
        idx++;
        // base case for null nodes
        if(nodes[idx]==-1) return null;
        // Node
        Node newNode = new Node(nodes[idx]);
        // left subtree
        newNode.left = buildTree(nodes);
        // right subtree
        newNode.right = buildTree(nodes);
        return newNode;
    }
    // preOrder traversal
    public static void preOrder(Node root) {
        if(root == null) return; // could print -1 as well
        // root
        System.out.print(root.data + "  ");
        // Left subtree
        preOrder(root.left); 
        // Right subtree
        preOrder(root.right); 
    }
    // Inorder traversal
    public static void inOrder(Node root) {
        if(root== null) return;
        // Left subtree
        inOrder(root.left);
        // Root
        System.out.print(root.data+"  ");
        // Right subtree
        inOrder(root.right);
    }
    // PostOrder Traversal
    public static void postOrder(Node root) {
        if(root == null) return;
        // left subtree
        postOrder(root.left);
        // Right subtree
        postOrder(root.right);
        // Root
        System.out.print(root.data+"  ");
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,6,-1,-1,7,-1,-1,-1,3,5,8,-1,-1,9,-1,-1,-1};
        Node root = buildTree(nodes);
        System.out.println("\nPreorder Traversal :");
        preOrder(root);
        System.out.println("\nInorder Traversal :");
        inOrder(root);
        System.out.println("\nPostorder Traversal :");
        postOrder(root);
    }
}
