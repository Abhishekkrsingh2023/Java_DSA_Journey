// package Day12;

public class PeakIndex {

    // gets the peak index from the array
    public static int getPeak(int[] arr) {
        int st = 1, end = arr.length-2; // End indices will never be peak
        int peak = -1;
        while(st <= end) {
            int mid = st + (end-st)/2;
            if(arr[mid-1]<arr[mid] && arr[mid]>arr[mid+1]) {
                peak = mid ;
                break;
            }
            else if(arr[mid]>arr[mid-1]) 
                st = mid+1; // mid is on the left half
            else 
                end = mid-1; // mid is on the right half
        }
        return peak; // peak index
    }
    public static void main(String[] args) {
        int arr[] = {0,3,8,9,5,4,2,1,-1};
        int arr2[] = {0,3,8,1};
        System.out.println(getPeak(arr));
        System.out.println(getPeak(arr2));
    }
}
