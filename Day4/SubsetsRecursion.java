// package Java_DSA_Journey.Day4;

import java.util.ArrayList;

public class SubsetsRecursion {
    public static void printSubset(int[] arr, int idx, ArrayList<Integer>subArr) {
        //base case
        if(idx == arr.length) {
            for(int ele : subArr) {
                System.out.print(ele + " ");
            }
            System.out.println();
            return;
        }
        //inclusion
        subArr.add(arr[idx]);
        printSubset(arr, idx+1, subArr);

        // backtracking
        subArr.remove(subArr.size() - 1);
        //exclusion
        printSubset(arr, idx+1, subArr);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<Integer> n = new ArrayList<>();
        printSubset(arr, 0, n);
    }
}
