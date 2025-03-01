
public class BinaryTreePreorder {
    // Node class
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
        
    }
    static int idx = -1;
    public static Node buildTree(int[] nodes) {
        idx++;
        if(nodes[idx]==-1) return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes); // left node
        newNode.right = buildTree(nodes); // right Node

        return newNode; // returns the root node
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes); // creating the Binary tree
        System.out.println(root.data);
    }
}