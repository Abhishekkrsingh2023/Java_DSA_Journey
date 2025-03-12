// package Day37;

public class BSTFromPreorder {
    // Node class for the Tree creation
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // Builds the BST from preorder traversal
    static Node createBst(int[] preorder, int[] idx, int lower, int upper) {
        // Base case
        if (idx[0] == preorder.length || preorder[idx[0]] < lower || preorder[idx[0]] > upper)
            return null;

        Node root = new Node(preorder[idx[0]]);
        idx[0]++; // Move to the next index
        root.left = createBst(preorder, idx, lower, root.data); // Upper bound is changed
        root.right = createBst(preorder, idx, root.data, upper);  // Lower boung is changed
        return root;
    }
    // inorder traversal
    static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        int []idx = {0}; // for reference index
        Node root = createBst(preorder, idx, Integer.MIN_VALUE,Integer.MAX_VALUE);
        inorder(root);
    }
}
