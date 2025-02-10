public class BinarySearchRecursion {
    // recursive Binary Search
    public static int binarySearch(int[] arr, int target, int st, int end) {
        if(st<=end) {        
            int mid = st +(end-st)/2;
            
            if(arr[mid] == target) return mid;
            else if(target < arr[mid]) // move left
                return binarySearch(arr, target, st, mid-1);
            else  // move right
                return binarySearch(arr, target, mid+1, end);
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,5,7,8,9};
        System.out.println(binarySearch(arr, 5, 0, arr.length-1));
        System.out.println(binarySearch(arr, 9, 0, arr.length-1));
        System.out.println(binarySearch(arr, 1, 0, arr.length-1));
        System.out.println(binarySearch(arr, 0, 0, arr.length-1));
    }
}
