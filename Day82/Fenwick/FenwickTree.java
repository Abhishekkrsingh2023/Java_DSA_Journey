package Fenwick;

public class FenwickTree {
    private int[] fenwickTree; // Fixed array declaration style
    private int size;

    // constructor to initialize the Fenwick Tree
    public FenwickTree(int[] arr) {
        this.size = arr.length;
        this.fenwickTree = new int[size + 1]; // initially every element is 0
        constructTree(arr);
    }

    // constructs the fenwick tree
    private void constructTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            update(i, arr[i]);
        }
    }

    // update Fenwick array
    public void update(int index, int value) {
        int i = index + 1; // since arr will be zero based
        while (i <= size) {
            fenwickTree[i] += value;
            i += i & (-i); // move to next index
        }
    }

    // query
    public int query(int index) {
        if (index + 1 > size)
            return Integer.MIN_VALUE;
        int i = index + 1;
        int sum = 0;
        while (i > 0) {
            sum += fenwickTree[i];
            i -= i & (-i);
        }
        return sum;
    }

    // range query
    public int query(int start, int end) {
        // just to handle 0 index
        return start == 0 ? query(end) : query(end) - query(start - 1);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 0, -2, 3, 6 };
        FenwickTree tree = new FenwickTree(arr);
        System.out.println(tree.query(3));
    }
}
