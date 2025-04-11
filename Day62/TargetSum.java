// package Day62;

import java.util.HashMap;

public class TargetSum {
    // brute force
    public static boolean getSum(int target, int[] nums) {
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        // get the desired sum
        for (int ele : nums) {
            if (getSum(target - ele, nums))
                return true;
        }
        return false;
    }

    // memoization(top-down approach)
    public static boolean getSum(int target, int[] nums, HashMap<Integer, Boolean> memo) {
        // Base case
        if (memo.containsKey(target))
            return memo.get(target);
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        // get the desired sum
        for (int ele : nums) {
            int rem = target - ele;
            if (getSum(rem, nums, memo)) {
                memo.put(rem, true);
                return true;
            }
        }
        memo.put(target, false); // Target not possible
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 14 };
        int target = 300;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        // System.out.println(getSum(target, nums));
        System.out.println(getSum(target, nums, memo));
    }
}
