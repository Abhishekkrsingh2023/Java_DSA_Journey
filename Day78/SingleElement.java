// package Day78;

public class SingleElement {
    public static int getSingleElement(int[] arr) {
        int ans = 0;
        // iterating the arr
        for (int ele : arr)
            ans ^= ele; // XOR operation
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2, 5, 1, 3, 5, 3, 1, 6 };
        System.out.println(getSingleElement(arr));
    }
}
