public class PreorderAndBST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
        }
    }
    static void createBst(int[] preorder,int N, int[] idx, int lower, int upper) {
        // Base case
        if (idx[0] == N || preorder[idx[0]] < lower || preorder[idx[0]] > upper)
            return;
        int data = preorder[idx[0]++]; // Move to the next index
        createBst(preorder, N, idx, lower, data); // Upper bound is changed
        createBst(preorder, N, idx, data, upper);  // Lower boung is changed
    }
    static boolean checkPreorder(int[] preorder, int N) {
        int[] idx = {0}; // for reference index
        createBst(preorder, N, idx, Integer.MIN_VALUE,Integer.MAX_VALUE);
        return idx[0] == N;
    }
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        int[] preorder2 = {8, 5, 1, 10, 7, 12}; // 7 is misplaced
        boolean ans = checkPreorder(preorder, preorder.length);
        boolean ans2 = checkPreorder(preorder2, preorder2.length);
        System.out.println(ans);    
        System.out.println(ans2);   
    }
}