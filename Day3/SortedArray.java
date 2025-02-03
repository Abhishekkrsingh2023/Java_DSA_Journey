// package Java_DSA_Journey.Day3;

public class SortedArray {

    public static boolean isSorted(int[] arr, int idx) {
        if(idx + 1 == arr.length) return true; // for end of arr
        if(arr[idx] >= arr[idx+1]) return false; // for unsorted case

        return isSorted(arr, idx+1); // recursive call
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int [] arr2 = {1,2,16,4,5,6,100};
        System.out.println(isSorted(arr, 0)); // first arr
        System.out.println(isSorted(arr2, 0)); // second arr
    }
}
