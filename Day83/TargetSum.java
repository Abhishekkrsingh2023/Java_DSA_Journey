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

public class TargetSum {
    public static Answer isTarget(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target)
                return new Answer(arr[l], arr[r]);
            else if (sum > target)
                r--;
            else
                l++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr2 = { -23, -18, -12, -8, -3, 0, 2, 7, 11, 15, 21, 27 };

        int target = 15;
        System.out.println(isTarget(arr, target)); // [5,10]
        System.out.println(isTarget(arr2, 3)); // [-18,21]
    }

}