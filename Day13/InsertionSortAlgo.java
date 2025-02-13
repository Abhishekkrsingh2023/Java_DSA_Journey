// package Day13;

public class InsertionSortAlgo {
    // Insertion sort Algo
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i=1;i<n && n>1;i++) {
            for(int j=i;j>0;j--) { // starting from index i
                if(arr[j-1] > arr[j]) {
                    // swap
                    int temp = arr[j];
                    arr[j]= arr[j-1];
                    arr[j-1] = temp;
                }
                else break;// already sorted
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,10,3,45,5};
        insertionSort(arr);

        for(int ele : arr) {
            System.out.print(ele+" ");
        }
    }
}
