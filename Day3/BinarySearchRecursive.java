// package Java_DSA_Journey.Day3;

public class BinarySearchRecursive {

    public static int BinarySearch(int[] arr,int key, int st, int end) {
        // search case
        if(st<=end) {
            int mid = st+(end-st)/2;
            if(arr[mid] == key) return mid;
            // left half
            else if(arr[mid]>key) return BinarySearch(arr,key, st, mid-1);
            // right half
            else return BinarySearch(arr, key, mid+1, end);
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {-1,2,5,16};
        System.out.println(BinarySearch(arr,16,0,arr.length-1));
        System.out.println(BinarySearch(arr,2,0,arr.length-1));
    }
}
