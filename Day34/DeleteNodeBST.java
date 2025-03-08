public class DeleteNodeBST {
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
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Inserts the node at specific position as per the condition
    static Node insertNode(Node root, int target) {
        if (root == null) {
            Node temp = new Node(target);
            return temp;
        }
        if (target >= root.data) { // conversion (we add duplicates to the right)
            root.right = insertNode(root.right, target);
        }
        if (target < root.data) {
            root.left = insertNode(root.left, target);
        }
        return root;
    }

    // created the bst
    static Node buildBst(int[] arr) {
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insertNode(root, arr[i]);
        }
        return root;
    }
    static Node deleteNode(Node root,int val) {
        if(root == null) return null;
        // searching the node 
        if(root.data > val) {
            root.left = deleteNode(root.left, val);
        }
        else if(root.data < val) {
            root.right =  deleteNode(root.right, val);
        }
        else { // found the node
            // no child 
            if(root.left == null && root.right == null) return null;
            
            // one child
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            // has both the childs
            else {
                Node inRoot = inorderSuccessor(root.right);
                root.data = inRoot.data;
                root.right = deleteNode(root.right, inRoot.data);
            }
        }
        return root;
    }
    static Node inorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int nodes[] = {5,10,6,2,1,9,16};
        Node root = buildBst(nodes);
        inOrder(root); // verifying using Inorder traversal
        deleteNode(root, 9);
        System.out.println();
        inOrder(root);
    }
}
