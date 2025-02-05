public class ArrayCreation {
    public static void main(String[] args) {
        int arr[] = new int[5]; // initially all elements are 0;
        arr[0] = 1;
        arr[2] = 2;
        arr[3] = 5;

        // displaying array elements
        for(int i = 0; i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}