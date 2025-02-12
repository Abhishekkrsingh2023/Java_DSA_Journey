// package Day12;

public class SingleElementInArray {
    
    // gets the single element
    public static int getSingle(int[] arr) {
        int n= arr.length;
        int st = 0,end = n-1;
        // n=1
        if(n==1) return arr[0];
        while(st <= end) {
            int mid = st + (end-st)/2;
            // mid = 0
            if(mid == 0 && arr[mid]!=arr[mid+1]) return arr[mid];
            // mid = n-1
            if(mid == n-1 && arr[mid]!=arr[mid-1]) return arr[mid];
            // mid is the single element
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1])
                return arr[mid];
            if(mid %2==0) { //even
                if(arr[mid] == arr[mid-1]) end=mid-1;
                else st = mid+1;
            }
            else { // odd
                if(arr[mid] == arr[mid-1]) st = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr = {1,1,2,3,3,5,5,6,6};
        System.out.println(getSingle(arr));
    }
}
