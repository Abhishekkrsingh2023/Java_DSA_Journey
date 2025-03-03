public class SumOfNodes{
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    static int idx = -1;
    // Builds the Binary tree
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
    // count nodes
    public static int getSum(Node root) {
        if(root == null) return 0;
        return root.data+getSum(root.left) + getSum(root.right);
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, 6, -1, -1, 7, -1, -1, -1, 3, 5, 8, -1, -1, 9, -1, -1,-1};
        /*
                    1
                   / \
                  2   3
                 /   /
                4    5  
               / \  / \
              6   7 8  9

         */
        Node root = buildTree(nodes); // builds the Binary tree
        System.out.println(getSum(root));
    }
}