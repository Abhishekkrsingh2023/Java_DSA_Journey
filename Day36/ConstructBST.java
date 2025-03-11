public class ConstructBST {
    // Node class for the Tree
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    // inorder Traversal for verification
    static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    // Creates the Balanced Binary Search Tree
    static Node createBst(int[] arr,int st, int end) {
        if(arr.length == 0) return null;
        if(st > end) return null;
        int mid = st+(end-st)/2;
        Node root = new Node(arr[mid]);
        root.left = createBst(arr, st, mid-1);
        root.right = createBst(arr, mid+1, end);
        return root;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        Node root = createBst(arr, 0, arr.length-1);
        inorder(root);
    }
}
