// package Day15;

public class QuickSortAlgorithm {
    // Quick sort algorithm
    public static void quickSort(int[] arr, int st ,int end) {
        if(st<end) {
            int pvtIdx = getPivot(arr,st,end); //gets the pivot
            // moving left
            quickSort(arr, st, pvtIdx-1);
            // moving right
            quickSort(arr, pvtIdx+1, end);
        }
    }

    // partition function that gets the pivot
    public static int getPivot(int[] arr, int st, int end) {
        int idx = st-1;
        int pivot = arr[end];
        for(int i=st;i<end;i++) {
            if(arr[i] <= pivot) {
                idx++;
                // function for swapping elements
                swap(arr, idx, i); 
            }
        }
        // adjusting pivot 
        idx++;
        swap(arr, idx, end);
        return idx;
    }

    public static void swap(int[] arr,int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int arr[] = {5,2,6,4,1,3};
        quickSort(arr, 0, arr.length-1);
        for(int ele:arr) 
            System.out.print(ele+" ");
        System.out.println();
    }
}
