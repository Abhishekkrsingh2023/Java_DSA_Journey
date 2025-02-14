// package Day14;

import java.util.ArrayList;

public class MergeSortAlgorithm {
    // Merge sort
    public static void mergeSort(int[] arr,int st, int end) {
        if(st >= end) return; // base case (1 element)
        int mid = st +(end-st)/2;
        // Divide step
        // left
        mergeSort(arr, st, mid);
        // right
        mergeSort(arr, mid+1, end);
        // conquer(Merge)
        merge(arr,st,end);
    }
    // merge function
    public static void merge(int[] arr, int st, int end) {
        int mid = st+(end-st)/2;
        ArrayList<Integer> temp = new ArrayList<>();
        int i=st,j=mid+1; // index of divided arrays
        // merging
        while(i<=mid && j<=end) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i++]);
            }
            else {
                temp.add(arr[j++]);
            }
        }
        // remaining elements
        while(i<=mid) temp.add(arr[i++]);
        while(j<=end) temp.add(arr[j++]);

        // copying to origianl array
        int idx = 0;
        while(idx < temp.size()) {
            arr[idx+st] = temp.get(idx++);
        }
    }
    public static void main(String[] args) {
        int[] arr = {12,31,35,8,32,17};
        mergeSort(arr, 0, arr.length-1);

        for(int ele:arr) {
            System.out.print(ele + " ");
        }
    }
}
