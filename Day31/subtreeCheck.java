// package Day31;

public class subtreeCheck {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    
    // Binary tree class
    static class BinaryTree {
        // Node root;
        int idx;
        BinaryTree() {
            idx = -1;
        }
        // Builds the Binary tree
        public Node buildTree(int[] nodes) {
            idx++;
            // base case for null nodes
            if (nodes[idx] == -1)
                return null;
            // Node
            Node newNode = new Node(nodes[idx]);
            // left subtree
            newNode.left = buildTree(nodes);
            // right subtree
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static boolean checkSub(Node Tree,Node subTree) {
        if(Tree == null && subTree == null) return true;
        if(Tree == null || subTree == null) return false;
        // if the data is equal we check for left & right part
        if(subTree.data == Tree.data) {
            return checkSub(Tree.left, subTree.left) && checkSub(Tree.right, subTree.right);
        }
        return false; // data is not equal
    }
    public static boolean isSubtree(Node Tree,Node subTree) {
        // Base cases
        if(subTree == null) return true;
        if(Tree == null) return false;

        if(Tree.data == subTree.data) {
            if(checkSub(Tree,subTree)) {
                return true;
            }
        }
        // checks for both left and right subtree
        return isSubtree(Tree.left, subTree) || isSubtree(Tree.right, subTree);
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 2, -1, -1, 7, -1, -1, 15, 12, -1, -1, 20, -10, -1, -1, 3, -1, -1 };

        /*
              10
             /  \
            5    15
           /  \  /  \
         2    7 12  20
                    /  \
                -10    3
           
         */

        int subT[] = {20,-10,-1,-1,3,-1,-1};
        BinaryTree b1 = new BinaryTree();
        BinaryTree b2 = new BinaryTree();

        // Tree and Subtreee
        Node Tree = b1.buildTree(nodes); 
        Node subTree = b2.buildTree(subT); 

        // Returns true or false
        System.out.println(isSubtree(Tree,subTree));
    
    }
}
