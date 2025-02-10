public class RotatedArrayBinarySearch {
    
    public static int binarySearch(int[] arr,int target) {
        int st = 0, end = arr.length -1;

        while(st <= end) {
            int mid = st + (end-st)/2; // memory optimized for large sized array
            if(arr[mid] == target) {
                return mid;
            }
            // left half is sorted
            if(arr[st] <= arr[mid]) { 
                if(arr[st] <= target && target <= arr[mid]) { // st <= target =>mid
                    // move left
                    end = mid -1;
                }
                else { 
                    // move right
                    st = mid+1;
                }
            }
            // Right half is sorted
            else { 
                if(target>=arr[mid] && target <=arr[end]) { // mid >= target <=end
                    // move rigth
                    st = mid + 1;
                }
                else {
                    // move left
                    end = mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {8,,1,2,3,4,5};
        System.out.println(binarySearch(arr, 1));
    }
}
