// package Day34;
 
public class BSTConstruction {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    // Inorder traversals sorts the Binary Search tree
    static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    // Inserts the node at specific position as per the condition
    static Node insertNode(Node root,int target) {
        if(root == null) {
            Node temp = new Node(target);
            return temp;
        }
        if(target >= root.data) { // conversion (we add duplicates to the right)
            root.right = insertNode(root.right, target);
        }
        if(target < root.data) {
            root.left = insertNode(root.left, target);
        }
        return root;
    }
    // created the bst
    static Node buildBst(int[] arr) {
        Node root=null;
        for(int i=0;i<arr.length;i++) {
            root = insertNode(root,arr[i]);
        }
        return root;
    }

    public static void main(String[] args) {
        int nodes[] = {5,3,8,2,4,6};
        int nodes2[] = {5,3,8,2,4,6,9,11,33,6};
        Node root = buildBst(nodes);
        Node root2 = buildBst(nodes2);
        inOrder(root); // verifying using Inorder traversal
        System.out.println();
        inOrder(root2);
    }
}
