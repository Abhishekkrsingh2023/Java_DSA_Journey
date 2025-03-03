// package Day29;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
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
    // Breadth First Search(BFS Traversal)
    public static void bfs(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            // for level wise printing
            for(int i=0;i<n;i++) {
                Node curr = q.remove();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                System.out.print(curr.data+" ");
            }
            System.out.println(); // nextline
        }
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, 6, -1, -1, 7, -1, -1, -1, 3, 5, 8, -1, -1, 9, -1, -1,-1};
        /*
                    1
                   / \
                  2   3
                 /   /
                4   5  
               / \  / \
              6   7 8  9

         */
        Node root = buildTree(nodes); // builds the Binary tree
        bfs(root); // level order traversing

    }
}
