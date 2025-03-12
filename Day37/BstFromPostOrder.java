// package Day37;

public class BstFromPostOrder {
    // Node class for the Tree creation
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // Builds the BST from postorder traversal
    static Node createBst(int[] postorder, int[] idx, int lower, int upper) {
        // Base case
        if (idx[0] < 0 || postorder[idx[0]] < lower || postorder[idx[0]] > upper)
            return null;

        Node root = new Node(postorder[idx[0]]);
        idx[0]--; // Move to the next index
        root.right = createBst(postorder, idx, root.data, upper);  // Lower bound is changed
        root.left = createBst(postorder, idx, lower, root.data); // Upper bound is changed
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
        int[] postorder = {1,7,5,12,10,8};
        int []idx = {postorder.length-1}; // for reference index
        Node root = createBst(postorder, idx, Integer.MIN_VALUE,Integer.MAX_VALUE);
        inorder(root);
    }
}
