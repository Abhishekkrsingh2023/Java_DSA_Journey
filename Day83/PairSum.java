package Day83;

class Answer {
    int a, b;

    public Answer(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "[" + this.a + "," + this.b + "]";
    }
}

public class PairSum {
    // gets the pair consecutive sum = target
    public static Answer getConsecutiveSum(int[] arr, int target) {
        int l = 0, r = 1, n = arr.length;
        int sum = arr[l];

        // sliding the window l,r
        while (r < n) {
            sum += arr[r];
            if (sum == target)
                // returning the answer
                return new Answer(arr[l], arr[r]);
            sum -= arr[l];
            l++;
            r++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, -2, 6, 11, 0, 7 };
        int target = 4;
        System.out.println(getConsecutiveSum(arr, target));
    }
}
