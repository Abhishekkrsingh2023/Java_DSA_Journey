// package Day79;
import java.util.Arrays;

public class CandyStore {
    public static int getCost(int[] candy, int k) {
        Arrays.sort(candy);
        int i = 0, j = candy.length - 1;
        int minCost = 0;
        while (i < j) {
            minCost += candy[i];
            j -= k;
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[] candy = { 5, 2, 1, 3, 7, 11 };
        int k = 2; // count of free candies
        System.out.println("min cost : " + getCost(candy, k));
    }
}
