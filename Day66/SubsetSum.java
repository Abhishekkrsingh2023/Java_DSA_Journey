// package Day66;

public class SubsetSum {
    public static boolean canPart(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int ele : arr)
            sum += ele;
        if (sum % 2 != 0)
            return false;
        return partition(arr, n - 1, sum / 2);
    }

    public static boolean partition(int[] arr, int idx, int target) {
        if (target == 0)
            return true;
        if (idx < 0 || target < 0)
            return false;
        return partition(arr, idx - 1, target - arr[idx]) || partition(arr, idx - 1, target);
    }

    // memoization
    public static boolean canPartMemo(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int ele : arr)
            sum += ele;
        if (sum % 2 != 0)
            return false;

        Boolean[][] memo = new Boolean[n][sum / 2 + 1];
        return partitionMemo(arr, n - 1, sum / 2, memo);
    }

    public static boolean partitionMemo(int[] arr, int idx, int target, Boolean[][] memo) {
        if (target == 0)
            return true;
        if (idx < 0 || target < 0)
            return false;

        if (memo[idx][target] != null)
            return memo[idx][target];

        // include or exclude
        boolean include = partitionMemo(arr, idx - 1, target - arr[idx], memo);
        boolean exclude = partitionMemo(arr, idx - 1, target, memo);

        return memo[idx][target] = include || exclude;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 11, 5 };
        int[] arr2 = { 3, 9, 11, 5, 2, 4 };
        int[] arr3 = { 1, 2, 5 };
        System.out.println(canPart(arr));
        System.out.println(canPart(arr2));
        System.out.println(canPart(arr3));
        System.out.println();
        System.out.println(canPartMemo(arr));
        System.out.println(canPartMemo(arr2));
        System.out.println(canPartMemo(arr3));
    }
}
