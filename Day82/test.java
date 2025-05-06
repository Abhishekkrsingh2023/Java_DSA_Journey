import Fenwick.FenwickTree;
public class test {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 0, -2, 3, 6 };
        FenwickTree tree = new FenwickTree(arr);
        System.out.println(tree.query(2));
        tree.update(3, 2);  // Update value at index 3 to 2
        System.out.println("Sum from index 0 to 4: " + tree.query(4));
        System.out.println("Sum of range 1 to 3: " + tree.query(1,3));
        System.out.println("Value at index 2: " + tree.query(4,5));
    }
}
