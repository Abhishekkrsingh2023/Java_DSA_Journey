
// package Day79;
import java.util.List;
import java.util.ArrayList;

public class MinCoins {
    public static List<Integer> getCoins(int[] coins, int amt) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (amt != 0) {
            int cnt = amt / coins[i];
            // storing the coins
            while (cnt-- != 0) {
                ans.add(coins[i]);
            }
            amt %= coins[i++]; // reducing the amount
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] coins = { 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1 };
        int amount = 233;
        List<Integer> result = getCoins(coins, amount);
        System.out.println("Coins used to make " + amount + ": " + result);
    }
}
