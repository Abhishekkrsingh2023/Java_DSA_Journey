import java.util.PriorityQueue;
import java.util.Collections;

public class MagicainAndChocolate {
    public static void main(String[] args) {
        // Example usage
        int[] chocolates = {6, 4, 2, 8};
        int turns = 3;
        System.out.println("Maximum chocolates collected: " + maxChocolates(chocolates, turns));
    }

    public static long maxChocolates(int[] A, int B) {
        // Create a max heap using PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Add all chocolates to the priority queue
        for (int chocolate : A) {
            pq.add(chocolate);
        }
        long totalChocolates = 0;
        // Process for B turns
        for (int i = 0; i < B; i++) {
            if (!pq.isEmpty()) {
                // Get the maximum chocolate pile
                int currentMax = pq.remove();
                // Add to total
                totalChocolates += currentMax;
                // Put back half of the chocolates
                pq.offer(currentMax / 2);
            }
        }
        return totalChocolates;
    }
}