public class HeightOfTree {
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
    // Finding the height
    public static int getHeight(Node root) {
        if(root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1+ Math.max(leftHeight, rightHeight);
    }
    public static void main(String[] args) {
        int nodes[] = {10, 5, 2, -1, -1, 7, -1, -1, 15, 12, -1, -1, 20, -10, -1, -1, 3, -1, -1};

        /*
                          10
                         /   \
                        5     15
                       / \   /  \
                      2   7  12  20
                                /  \
                              -10   3


         */
        Node root = buildTree(nodes); // builds the Binary tree
        System.out.println(getHeight(root));
    }
}
