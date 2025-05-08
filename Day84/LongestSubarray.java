import java.util.ArrayList;
import java.util.List;

class Answer {
    List<Integer> ans;

    public Answer(int[] arr, int l, int r) {
        ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
    }

    @Override
    public String toString() {
        return this.ans.toString();
    }
}

public class LongestSubarray {
    // gets the max length
    public static Answer getSubarray(int[] arr, int k) {
        int l = 0, r = 0, n = arr.length;
        int maxLen = 0, sum = 0;
        int a = -1, b = -1;
        int maxSum = Integer.MIN_VALUE;
    
        while (r < n) {
            sum += arr[r];
            // shrinking the window size
            while (sum > k && l <= r) {
                sum -= arr[l];
                l++;
            }
            if (sum <= k) {
                int len = r - l + 1;
                if (len > maxLen || (len == maxLen && sum > maxSum)) {
                    maxLen = len;
                    maxSum = sum;
                    a = l;
                    b = r;
                }
            }
            r++; 
        }
        return new Answer(arr, a, b);
    }
    

    public static void main(String[] args) {
        int[] arr = { 3, 10, 2, 1, 6, 0, 7, 8 };
        int k = 11;
        int[] arr2 = { 2, 2, 2 };
        System.out.println(getSubarray(arr, k));
        System.out.println(getSubarray(arr2, 2));
    }
}