// package Day26;

public class CountSort {
    public static void countSort(int[] arr) {
        int maxSize = 0;
        for(int i=0;i<arr.length;i++) {
            maxSize = Math.max(arr[i], maxSize);
        }
        // frequency arr
        int[] freq = new int[maxSize+1];
        for(int i=0;i<arr.length;i++) {
            freq[arr[i]]++;
        }
        // Finding CF
        for(int i=1;i<freq.length;i++) {
            freq[i] = freq[i-1]+freq[i];
        }


        // main algo of count sort
        int output[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            int idx = --freq[arr[i]]; // getting the index
            output[idx] = arr[i];
        }
        for(int i=0;i<arr.length;i++) {
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,1,1,5,2,6,13};
        countSort(arr);
        for(int ele:arr) {
            System.out.print(ele+" ");
        }
    }
}
