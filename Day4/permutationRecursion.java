import java.util.ArrayList;

public class permutationRecursion {

    // swapping function
    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void getPermutation(ArrayList<Integer> arr, int idx, ArrayList<ArrayList<Integer>> per) {
        if (idx == arr.size()) {
            per.add(new ArrayList<>(arr)); // Add a copy of arr
            return; // Return to avoid further recursion
        }

        for (int i = idx; i < arr.size(); i++) {
            swap(arr, i, idx); // Swapping
            getPermutation(arr, idx + 1, per);
            swap(arr, idx, i); // Backtracking
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> n = new ArrayList<>();
        ArrayList<Integer> x = new ArrayList<>();
        x.add(1);
        x.add(2);
        x.add(3);

        getPermutation(x, 0, n);

        // Printing permutations
        for (ArrayList<Integer> perm : n) {
            System.out.println(perm);
        }
    }
}
