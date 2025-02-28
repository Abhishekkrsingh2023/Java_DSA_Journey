// package Day26;

public class RadixSortAlgorithm {
    public static void countSort(int arr[], int pos) {
        // Frequency array
        int[] freq = new int[10];
        for (int i = 0; i < arr.length; i++) {
            int idx = (arr[i] / pos) % 10;
            freq[idx]++;
        }
    
        // Finding Cumulative Frequency
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
    
        // Main Counting Sort algorithm (Right to Left for Stability)
        int output[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {  // FIXED
            int idx = (arr[i] / pos) % 10;
            output[--freq[idx]] = arr[i];
        }
    
        // Copy sorted elements back to arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
    
    public static void radixSort(int arr[]) {
        int maxEle = 0;
        for (int i = 0; i < arr.length; i++) {
            maxEle = Math.max(arr[i], maxEle);
        }
    
        // sorting for each position
        for (int pos = 1; pos <= maxEle; pos *= 10) {  // FIXED
            countSort(arr, pos);
        }
    }
    

    public static void main(String[] args) {
        int arr[] = { 101, 250, 6653, 213, 1, 6 };
        System.out.println("Before Sorting : ");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        // sorting
        radixSort(arr);
        System.out.println("\nAfter Sorting");
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
}
