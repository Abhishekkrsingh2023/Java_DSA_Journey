// package Day31;

public class OptimizedDiameter {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static int idx = -1;

    // Builds the Binary tree
    public static Node buildTree(int[] nodes) {
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

    // holds the diameter and height of current node   
    static class TreeNode {
        int ht;
        int dia;

        TreeNode(int ht, int dia) {
            this.ht = ht;
            this.dia = dia;
        }
    }

    // Diameter
    public static TreeNode getDiameter(Node root) {
        if(root == null) {
            return new TreeNode(0, 0);
        }
        // Left subtree height and Dia
        TreeNode leftTree = getDiameter(root.left);
        // Right subtree height and Dia
        TreeNode rightTree = getDiameter(root.right);
        
        // max height
        int htMax = 1 + Math.max(leftTree.ht, rightTree.ht);
        // max Diameter
        int midDia = leftTree.ht + rightTree.ht + 1;
        int maxDia = Math.max(midDia, Math.max(leftTree.dia, rightTree.dia));
        return new TreeNode(htMax, maxDia);
    }

    public static void main(String[] args) {
        int nodes[] = { 10, 5, 2, -1, -1, 7, -1, -1, 15, 12, -1, -1, 20, -10, -1, -1, 3, -1, -1 };

        /*
              10
              / \
             5   15
            / \  / \
           2   7 12 20
                    / \
                  -10  3

         */
        Node root = buildTree(nodes); // builds the Binary tree
        System.out.println(getDiameter(root).dia);
        
    }
}
