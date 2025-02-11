// package Day11;

public class FirstLastOccurence {
    // gets the first occurence
    public static int getFirstIndex(int[] arr, int target) {
        int st = 0,end = arr.length-1;
        int first = -1; // for missing target
        while(st<=end) {
            int mid = st +(end-st)/2;
            if(arr[mid] == target) {
                first = mid;
                end = mid-1;
            }
            else if(target < arr[mid]) {
                end = mid -1;
            }
            else {
                st = mid+1;
            }
        }
        return first;
    }
    // gets the last index
    public static int getLastIndex(int[] arr, int target) {
        int st = 0,end = arr.length-1;
        int last = -1; // for missing target
        while(st<=end) {
            int mid = st +(end-st)/2;
            if(arr[mid] == target) {
                last = mid;
                st = mid+1; 
            }
            else if(target < arr[mid]) {
                end = mid -1;
            }
            else {
                st = mid+1;
            }
        }
        return last;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5,6,7};
        int target = 3;

        int firstOcc = getFirstIndex(arr,target); // first occurence (-1 if absent)
        int lastOcc = getLastIndex(arr,target); // last occurence (-1 if absent)

        System.out.println(firstOcc+"  "+lastOcc);
    }
}
