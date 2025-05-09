import java.util.HashMap;

public class FruitCount {
    public static int getCount(int[] fruits) {
        int n = fruits.length, maxLen = 0, l = 0, r = 0, k = 2;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        // sliding window
        while (r < n) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);

            while (mpp.size() > k) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0)
                    mpp.remove(fruits[l]);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] fruits = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(getCount(fruits));
    }
}
