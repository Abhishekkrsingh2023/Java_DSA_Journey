import java.util.ArrayList;

public class DuplicateSubset {
    public static ArrayList<ArrayList<Integer>> subset(int[] arr, int idx, ArrayList<Integer> subArr,ArrayList<ArrayList<Integer>> x) {
        if(idx == arr.length) {
            x.add(new ArrayList<>(subArr));
            return x;
        }
        // inclusion
        subArr.add(arr[idx]);
        subset(arr, idx+1, subArr, x);
        subArr.remove(subArr.size() -1);
        int i = idx+1;
        while(i<arr.length && arr[i] == arr[i-1]) i++;
        // exclusion
        subset(arr, i, subArr, x);        
        return x;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> x = new ArrayList<>();
        System.out.println(subset(new int[]{1, 2, 2,3,3}, 0, new ArrayList<>(), x));
    }
}
