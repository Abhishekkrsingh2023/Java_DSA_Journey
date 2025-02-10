// package Day10;

public class BinarySearchWhile {

    // Binary Search function (Iterative approach)
    public static int binarySearch(int[] arr,int target) {
        int start = 0, end = arr.length -1;

        while(start <= end) {
            int mid = start + (end-start)/2; // memory optimized for large sized array
            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid]>target) { // search left half
                end = mid-1;
            }
            else {
                // move right
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,9,14,16,33,40};
        
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 40));
        System.out.println(binarySearch(arr, -10));
    }
}
