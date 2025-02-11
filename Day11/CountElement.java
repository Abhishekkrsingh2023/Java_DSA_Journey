public class CountElement {
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

    // gets the count
    public static int getCount(int[] arr,int target) {
        int first = getFirstIndex(arr, target);
        int last = getLastIndex(arr, target);

        if(first != -1) {
            return last-first+1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5,6,7};
        System.out.println(getCount(arr, 3)); // 4
        System.out.println(getCount(arr, 15)); // 0
        System.out.println(getCount(arr, 4)); // 1

    }
}
