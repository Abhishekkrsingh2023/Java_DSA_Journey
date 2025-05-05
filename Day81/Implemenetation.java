import SegTree.SegmentTree;

import java.util.Scanner;

public class Implemenetation {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 10, 13, 0, 5};
        SegmentTree tree = new SegmentTree(arr);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of query : ");
        int n = sc.nextInt();
        while (n-- != 0) {
            System.out.print("Enter start and end index : ");
            int st = sc.nextInt();
            int end = sc.nextInt();
            System.out.println("Sum from " + st + "to " + end + "is : " + tree.query(st, end));
        }
        // updating the tree
        tree.update(4,55);
        System.out.println(tree.query(0,4));

    }
}