public class LinearSearch {

    public static int linSearc(int[] arr,int target) {
        // traversing the array
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == target) return i;
        }

        return -1; // if element is absent
    }
    public static void main(String[] args) {
        int[] arr = {1,5,6,4,9,10,16};
        int target = 10;
        System.out.println(linSearc(arr, target));
        System.out.println(linSearc(arr, 0)); // -1, no element
    }
}