// package Day13;

public class SelectionSortAlgo {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            int idx = i; // ith index
            for(int j=i;j<n;j++) {
                if(arr[idx] < arr[j]) {
                    idx = j; // index of max element
                }
            }
            // swapping
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        selectionSort(arr);

        for(int ele : arr) {
            System.out.print(ele+" ");
        }
    }
}
