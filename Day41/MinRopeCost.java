import java.util.PriorityQueue;

public class MinRopeCost {
    public static int minCost(int[] ropes) {
        if (ropes == null || ropes.length < 2) {
            return 0;
        }
        // Create a min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Add all ropes to the heap
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;
        // Keep connecting ropes until only one rope is left
        while (minHeap.size() > 1) {
            // Take the two shortest ropes
            int first = minHeap.remove();
            int second = minHeap.remove();
            // Cost of connecting these ropes
            int cost = first + second;
            // Add the cost to total
            totalCost += cost;
            // Add the connected rope back to heap
            minHeap.add(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println("Minimum cost to connect ropes: " + minCost(ropes));
    }
}