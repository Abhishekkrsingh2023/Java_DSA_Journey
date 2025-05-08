public class MaxPoints {
    public static int maxPoint(int[] arr, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0;
        int rightIdx = arr.length - 1, leftIdx = k - 1;
        // initial sum
        for (int i = 0; i < k; i++) {
            leftSum += arr[i];
        }
        // sliding the window
        while (leftIdx >= 0) {
            maxSum = Math.max(maxSum, leftSum + rightSum);
            leftSum -= arr[leftIdx--];
            rightSum += arr[rightIdx--];
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
        int k = 4;

        System.out.println(maxPoint(arr, k));
    }
}
