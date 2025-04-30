import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> getPowerSet(int[] seq) {
        int n = 1 << seq.length; // number of elements in power set
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // checking for set bit
                if ((i & (1 << j)) != 0) {
                    ans.add(seq[j]);
                }
            }
            // adds to the power-set
            sol.add(ans);
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<List<Integer>> ans = getPowerSet(arr);
        for (var set : ans)
            System.out.println(set);
    }
}
