public class CountOnes {
    // Brute force
    public static int getMaxCount(int[] arr, int k) {
        int zeroes = 0, maxLen = 0, n = arr.length;
        // finding the sub arrays
        for (int i = 0; i < n; i++) {
            zeroes = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0)
                    zeroes++;
                if (zeroes <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break;
            }
        }
        return maxLen;
    }

    // optimized approach
    public static int getMaxOnes(int[] arr, int k) {
        int zero = 0, maxLen = 0, l = 0, r = 0;
        int n = arr.length;
        while (r < n) {
            // zero encountered
            if (arr[r] == 0)
                zero++;
            // checking for validity
            while (zero > k) {
                if (arr[l] == 0)
                    zero--;
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;

        System.out.println(getMaxCount(arr, k));
        System.out.println(getMaxOnes(arr, k));
    }
}
