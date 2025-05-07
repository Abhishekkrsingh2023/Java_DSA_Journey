// package Day83;

import java.util.ArrayList;

// Answer class for our answer
class Answer {
    int left, right;
    ArrayList<Integer> ans;

    public Answer(int[] arr, int left, int right) {
        ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
    }

    @Override
    public String toString() {
        return this.ans.toString();
    }
}

public class TargetWindow {
    // gets the subarray (size 4)with the max sum
    public static Answer getMaxWindow(int[] arr, int k) {
        int l = 0, r = k - 1, sum = 0, maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        // initial window
        for (int i = 0; i < r; i++)
            sum += arr[i];
        int a = -1, b = -1;
        // sliding the window
        while (r < n) {
            sum += arr[r];
            if (sum > maxSum) {
                maxSum = sum;
                // indices for the subarray
                a = l;
                b = r;
            }
            sum -= arr[l];
            // moving to next window(consecutive)
            l++;
            r++;
        }
        return new Answer(arr, a, b);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, -2, 6, 11, 0, 7, -5, 33, 2, 8, -10 };
        int k = 4;

        Answer ans = getMaxWindow(arr, k);
        System.out.println(ans);
    }

}
